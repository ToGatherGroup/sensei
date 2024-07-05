package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.BuscarAvaliacaoPorAtletaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarAvaliacaoPorAtletaDataServiceImpl implements BuscarAvaliacaoPorAtletaDataService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaRepository atletaRepository;


    @Override
    public AvaliacaoModel findAvaliacao(Long atletaId, LocalDate data) {
        AtletaModel atleta = validarAtleta(atletaId);
        AvaliacaoModel avaliacao= avaliacaoRepository.buscaAvaliacaoAtletaData(data,atletaId);

        return avaliacao;
    }

    private AtletaModel validarAtleta(Long atletaId){

        Optional<AtletaModel> atleta= atletaRepository.findById(atletaId);
        if (atleta.isEmpty()) throw new BusinessException("Atleta não encontrado");

        return atleta.get();

    }
}
