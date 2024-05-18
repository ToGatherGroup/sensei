package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import com.togather.sensei.services.avaliacaoService.VerificaAvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerificaAvaliacaoIncompletaServiceImpl implements VerificaAvaliacaoIncompletaService {

    private final AvaliacaoRepository avaliacaoRepository;


    @Override
    public Boolean verificarAvaliacoesIncompletas() {
        List<AvaliacaoModel> listaAvaliacaoIncompleta= avaliacaoRepository.getAvaliacoesIncompletas();
        return !listaAvaliacaoIncompleta.isEmpty();
    }
}
