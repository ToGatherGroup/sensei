package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RegistraExercicioColetivoServiceImpl implements RegistraExercicioColetivoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;
    private final NullBeanUtils nullBeanUtils;

    @Override
    public void atualizarExercicioColetivo(List<ExercicioColetivoDTO> listaExercicioColetivo) throws InvocationTargetException, IllegalAccessException {
        LocalDate data = avaliacaoRepository.getDataAvaliacoesIncompletas();

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
    }
}
