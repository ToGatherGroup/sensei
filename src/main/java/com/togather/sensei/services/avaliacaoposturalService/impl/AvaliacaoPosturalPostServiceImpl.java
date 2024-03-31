package com.togather.sensei.services.avaliacaoposturalService.impl;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoPosturalPostServiceImpl implements AvaliacaoPosturalPostService {

    private final AvaliacaoPosturalRepository avaliacaoPosturalRepository;
    @Override
    public AvaliacaoPosturalModel saveAvaliacaoPostural(AvaliacaoPosturalModel avaliacaoPosturalModel) {

        return avaliacaoPosturalRepository.save(avaliacaoPosturalModel);
    }
}
