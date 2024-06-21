package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.DTO.avaliacao.PossuiAvaliacaoIncompletaDTO;
import com.togather.sensei.helper.NullBeanUtils;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.RegistraExercicioColetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.*;

@Service
@RequiredArgsConstructor

public class RegistraExercicioColetivoServiceImpl implements RegistraExercicioColetivoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;
    private final NullBeanUtils nullBeanUtils;

    @Override
    public PossuiAvaliacaoIncompletaDTO atualizarExercicioColetivo(List<ExercicioColetivoDTO> listaExercicioColetivo) throws InvocationTargetException, IllegalAccessException {

        LocalDate data = avaliacaoRepository.getDataAvaliacoesIncompletas();

        if (isNull(data)){
            return PossuiAvaliacaoIncompletaDTO.builder().avaliacaoEstaCompleta(Boolean.TRUE).build();
        }

        List<AvaliacaoModel> avaliacoesAtualizada = new ArrayList<>();

        List<Long> atletaIds = listaExercicioColetivo.stream()
                .map(ExercicioColetivoDTO::getAtletaId)
                .collect(Collectors.toList());

        Set<Long> atletasExistentes = atletaRepository.findAllById(atletaIds).stream()
                .map(AtletaModel::getId).collect(Collectors.toSet());

        List<ExercicioColetivoDTO> exerciciosFiltrados = listaExercicioColetivo.stream()
                .filter(exercicio -> atletasExistentes.contains(exercicio.getAtletaId()))
                .toList();

        List<AvaliacaoModel> avaliacoes = avaliacaoRepository.findAllByDataAndAtletaIdIn(data, atletaIds);

        Map<Long, AvaliacaoModel> avaliacoesMap = avaliacoes.stream()
                .collect(Collectors.toMap(avaliacao -> avaliacao.getAvaliacaoModelId().getAtletaModel().getId(), avaliacao -> avaliacao));

        for (ExercicioColetivoDTO exercicioColetivo : exerciciosFiltrados) {
            AvaliacaoModel avaliacao = avaliacoesMap.get(exercicioColetivo.getAtletaId());
            if (avaliacao != null) {
                nullBeanUtils.copyProperties(avaliacao, exercicioColetivo.getResultado());
            }
            avaliacoesAtualizada.add(avaliacao);
        }
        avaliacaoRepository.saveAll(avaliacoesAtualizada);

        LocalDate dataAposSalvar = avaliacaoRepository.getDataAvaliacoesIncompletas();

        return verificarAvaliacoesIncompletas(dataAposSalvar);
    }

    private PossuiAvaliacaoIncompletaDTO verificarAvaliacoesIncompletas(LocalDate data) {
        if (isNull(data)){
            return PossuiAvaliacaoIncompletaDTO.builder().avaliacaoEstaCompleta(Boolean.TRUE).build();
        }
        return PossuiAvaliacaoIncompletaDTO.builder().avaliacaoEstaCompleta(Boolean.FALSE).build();
    }
}
