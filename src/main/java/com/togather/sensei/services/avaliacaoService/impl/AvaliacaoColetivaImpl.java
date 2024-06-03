package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoColetivaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AvaliacaoColetivaImpl implements AvaliacaoColetivaService {
    private final AvaliacaoRepository avaliacaoRepository;

    private final AtletaRepository atletaRepository;
    @Override
    public void cadastrarAvaliacaoColetiva() {
        List<AtletaModel> listaAtletaIdAtivo = atletaRepository.buscaListaAtletaIdAtivo();
        LocalDate dataAtual = LocalDate.now();

        for (AtletaModel atletaId: listaAtletaIdAtivo) {
            AvaliacaoModelId avaliacaoModelId = new AvaliacaoModelId(atletaId, dataAtual);
            AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
            avaliacaoModel.setAvaliacaoModelId(avaliacaoModelId);
            avaliacaoRepository.save(avaliacaoModel);
        }
    }
}
