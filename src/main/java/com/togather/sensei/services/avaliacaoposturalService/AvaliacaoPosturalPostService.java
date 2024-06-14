package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AvaliacaoPosturalPostService {
    void saveAvaliacaoPostural(List<AvaliacaoPosturalModel> avaliacaoPosturalList);
}
