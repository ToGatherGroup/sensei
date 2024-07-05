package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.models.AvaliacaoModel;

import java.time.LocalDate;
import java.util.List;

public interface BuscarAvaliacaoPorAtletaDataService {

    ResponseBuscaAvaliacaoDTO findAvaliacao(Long atletaId, LocalDate data);
}
