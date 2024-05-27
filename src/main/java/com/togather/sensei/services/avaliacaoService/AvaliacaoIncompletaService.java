package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.models.AvaliacaoModel;

import java.util.List;

public interface AvaliacaoIncompletaService {
    List<AvaliacaoDTO> buscaAvaliacoesIncompletas();
}
