package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AvaliacoesPosturaisByDataService {
    List<AvaliacaoPosturalModel> buscarAvaliacoesPosturalByData(Long atletaId, LocalDate data);
}
