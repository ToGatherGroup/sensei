package com.togather.sensei.services.avaliacaoposturalService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AvaliacaoPosturalGetDataService {
    List<LocalDate> buscarDatasDeAvaliacoesPorAtletaId(Long atletaId);
}
