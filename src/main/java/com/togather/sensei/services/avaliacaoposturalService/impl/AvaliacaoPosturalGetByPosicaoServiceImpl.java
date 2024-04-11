package com.togather.sensei.services.avaliacaoposturalService.impl;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalGetByIdPosicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AvaliacaoPosturalGetByPosicaoServiceImpl implements AvaliacaoPosturalGetByIdPosicaoService {

    private final AvaliacaoPosturalRepository avaliacaoPosturalRepository;
    @Override
    public String buscarAvaliacaoPosturalByPosicao(Long atletaId, LocalDate data, PosicaoFotoEnum posicao) {
        Object foto = avaliacaoPosturalRepository.buscarAvaliacaoPosturalByPosicao(atletaId, data, posicao);
        return foto.toString();
    }
}
