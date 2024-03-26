package com.togather.sensei.services.presencaService;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;

public interface PresencasDeAtletaService {
    PresencaAtletaDTO buscarPresencasPorAtleta(Long idAtleta, String inicio, String fim);
}
