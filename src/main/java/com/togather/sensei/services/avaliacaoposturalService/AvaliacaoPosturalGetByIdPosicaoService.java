package com.togather.sensei.services.avaliacaoposturalService;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface AvaliacaoPosturalGetByIdPosicaoService {
    String buscarAvaliacaoPosturalByPosicao (Long atletaId, LocalDate data, PosicaoFotoEnum posicao);
}
