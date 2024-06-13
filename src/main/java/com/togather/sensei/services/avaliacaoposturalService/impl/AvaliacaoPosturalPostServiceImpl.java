package com.togather.sensei.services.avaliacaoposturalService.impl;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoPosturalPostServiceImpl implements AvaliacaoPosturalPostService {

    private final AvaliacaoPosturalRepository avaliacaoPosturalRepository;
    @Override
    public void saveAvaliacaoPostural(List<AvaliacaoPosturalModel> avaliacaoPosturalList) {

        for (AvaliacaoPosturalModel avaliacaoPostural: avaliacaoPosturalList) {
            avaliacaoPosturalRepository.save(avaliacaoPostural);
        }
    }
}
