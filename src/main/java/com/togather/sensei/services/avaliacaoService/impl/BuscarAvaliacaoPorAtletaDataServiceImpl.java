package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.DTO.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.BuscarAvaliacaoPorAtletaDataService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarAvaliacaoPorAtletaDataServiceImpl implements BuscarAvaliacaoPorAtletaDataService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;
    private final ModelMapper modelMapper;


    @Override
    public ResponseBuscaAvaliacaoDTO findAvaliacao(Long atletaId, LocalDate data) {
        AtletaModel atleta = validarAtleta(atletaId);
        AvaliacaoModel avaliacao= avaliacaoRepository.buscaAvaliacaoAtletaData(data,atletaId);
        ListaExerciciosDTO exercicios = modelMapper.map(avaliacao, ListaExerciciosDTO.class);
        ResponseBuscaAvaliacaoDTO responseAvaliacao = new ResponseBuscaAvaliacaoDTO(atletaId,data,exercicios);
        return responseAvaliacao;
    }

    private AtletaModel validarAtleta(Long atletaId){

        Optional<AtletaModel> atleta= atletaRepository.findById(atletaId);
        if (atleta.isEmpty()) throw new BusinessException("Atleta não encontrado");

        return atleta.get();

    }
}
