package com.togather.sensei.services.avaliacaoposturalService.impl;

import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacoesPosturaisByDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacoesPosturaisByPosicaoServiceImpl implements AvaliacoesPosturaisByDataService {

    private final AvaliacaoPosturalRepository avaliacaoPosturalRepository;

    @Override
    public List<AvaliacaoPosturalModel> buscarAvaliacoesPosturalByData(Long atletaId, LocalDate data) {
        List<AvaliacaoPosturalModel> listaPosicao = avaliacaoPosturalRepository.buscarAvaliacoesPosturaisByData(atletaId, data);
        return listaPosicao;
    }

    private String buscaDescricaoEnum(int index) {
        PosicaoFotoEnum[] lista = PosicaoFotoEnum.values();
        String descricao = lista[index].getPosicao();

        return descricao;
    }
}
