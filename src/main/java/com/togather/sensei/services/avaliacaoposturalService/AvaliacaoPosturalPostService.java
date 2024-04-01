package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.stereotype.Service;

@Service
public interface AvaliacaoPosturalPostService {
    AvaliacaoPosturalModel saveAvaliacaoPostural(AvaliacaoPosturalModel avaliacaoPosturalModel);
}
