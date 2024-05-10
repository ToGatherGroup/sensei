package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.models.AvaliacaoPosturalPK;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public interface AvaliacoesPosturaisByDataService {
    List<AvaliacaoPosturalDTO> buscarAvaliacoesPosturalByData(Long atletaId, LocalDate data);
}
