package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;

import java.util.List;

public interface AvaliacaoService {
    List<AvaliacaoIncompletaDTO> buscaAvaliacoesIncompletas(String exercicio);
}
