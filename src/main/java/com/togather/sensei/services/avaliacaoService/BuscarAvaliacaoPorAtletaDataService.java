package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.models.AvaliacaoModel;

import java.time.LocalDate;
import java.util.List;

public interface BuscarAvaliacaoPorAtletaDataService {

    AvaliacaoModel findAvaliacao(Long atletaId, LocalDate data);
}
