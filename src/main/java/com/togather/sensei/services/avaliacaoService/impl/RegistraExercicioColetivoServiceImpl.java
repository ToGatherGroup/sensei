package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.helper.NullBeanUtils;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.RegistraExercicioColetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RegistraExercicioColetivoServiceImpl implements RegistraExercicioColetivoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;
    private final NullBeanUtils nullBeanUtils;


    @Override
    public void atualizarExercicioColetivo(List<ExercicioColetivoDTO> listaexercicioColetivo) throws InvocationTargetException, IllegalAccessException {
        for (ExercicioColetivoDTO exercicioColetivo:listaexercicioColetivo) {

            AtletaModel atleta = validaAtleta(exercicioColetivo.getAtletaId()) ;
            LocalDate data = avaliacaoRepository.getDataAvaliacoesIncompletas();
            AvaliacaoModelId id= new AvaliacaoModelId(atleta,data);

            AvaliacaoModel avaliacao= avaliacaoRepository.findById(id).get();
            System.out.println(avaliacao);
            nullBeanUtils.copyProperties(avaliacao,exercicioColetivo.getResultado());
            avaliacaoRepository.save(avaliacao);
        }

    }

    private AtletaModel validaAtleta(Long id){
        Optional<AtletaModel> atleta = atletaRepository.findById(id) ;
        if (atleta.isEmpty()) throw new NotFoundException("Atleta não encontrado");

        return atleta.get();
    }
}
