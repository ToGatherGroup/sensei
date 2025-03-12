package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.dtos.avaliacaopostural.AvaliacaoPosturalDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AvaliacoesPosturaisByDataService {
    List<AvaliacaoPosturalDTO> buscarAvaliacoesPosturalByData(Long atletaId, LocalDate data);
}
