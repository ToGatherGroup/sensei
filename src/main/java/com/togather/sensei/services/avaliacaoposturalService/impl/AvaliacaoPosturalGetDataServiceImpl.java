package com.togather.sensei.services.avaliacaoposturalService.impl;

import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalGetDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoPosturalGetDataServiceImpl implements AvaliacaoPosturalGetDataService {

    private final AvaliacaoPosturalRepository avaliacaoPosturalRepository;
    @Override
    public List<LocalDate> buscarDatasDeAvaliacoesPorAtletaId(Long atletaId) {
        return avaliacaoPosturalRepository.buscarDatasDeAvaliacoesPorAtletaId(atletaId);
    }
}
