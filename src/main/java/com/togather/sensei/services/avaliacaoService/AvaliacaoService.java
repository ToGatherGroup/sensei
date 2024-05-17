package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;
import com.togather.sensei.models.AvaliacaoModelId;

import java.util.List;

public interface AvaliacaoService {
    List<AtletaIdNomeDTO> buscaAvaliacoesIncompletas(String exercicio );
}
