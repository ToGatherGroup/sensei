package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.dtos.avaliacao.ResponseBuscaAvaliacaoDTO;

import java.time.LocalDate;

public interface BuscarAvaliacaoPorAtletaDataService {

    ResponseBuscaAvaliacaoDTO findAvaliacao(Long atletaId, LocalDate data);
}
