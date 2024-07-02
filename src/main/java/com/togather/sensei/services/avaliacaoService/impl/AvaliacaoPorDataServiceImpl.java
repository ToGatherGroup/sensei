package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoPorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoPorDataServiceImpl implements AvaliacaoPorDataService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<String> buscaAvaliacoes() {
        return avaliacaoRepository.getAvaliacoesPorData();
    }
}
