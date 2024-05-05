package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.geral.SeriesDTO;

public interface AvaliacoesPorAtletaService
{
    SeriesDTO getAvaliacoesPorAtleta(Long atletaId);
}