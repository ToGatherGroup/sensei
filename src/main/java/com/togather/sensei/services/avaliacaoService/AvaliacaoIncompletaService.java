package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;

import java.util.List;

public interface AvaliacaoIncompletaService {
    List<AtletaIdNomeDTO> buscaAvaliacoesIncompletas(String exercicio );
}
