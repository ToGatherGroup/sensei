package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoPostServiceImpl implements AvaliacaoPostService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public void saveAvaliacao(AvaliacaoModel avaliacaoModel) {
        avaliacaoRepository.save(avaliacaoModel);
    }
}
