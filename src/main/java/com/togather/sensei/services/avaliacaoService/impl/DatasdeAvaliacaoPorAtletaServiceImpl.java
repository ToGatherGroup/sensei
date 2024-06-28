package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.DatasDeAvaliacaoPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DatasdeAvaliacaoPorAtletaServiceImpl implements DatasDeAvaliacaoPorAtletaService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<Date> buscarDatasAvaliacoesPorAtleta(Long atletaId) {
        return avaliacaoRepository.buscaAvaliacaoPorDataPorAtleta(atletaId);
    }

}




