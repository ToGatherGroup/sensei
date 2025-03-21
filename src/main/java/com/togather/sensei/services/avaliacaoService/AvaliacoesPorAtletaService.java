package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.dtos.geral.MetricaAvaliacao;
import com.togather.sensei.dtos.geral.SeriesDTO;

import java.util.List;

public interface AvaliacoesPorAtletaService
{
    SeriesDTO getAvaliacoesPorAtleta(Long atletaId);

    List<MetricaAvaliacao> getMetricasAvaliacao();
}