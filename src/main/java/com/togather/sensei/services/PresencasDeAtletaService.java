package com.togather.sensei.services;

import com.togather.sensei.DTO.PresencaAtletaDTO;

public interface PresencasDeAtletaService {
    PresencaAtletaDTO buscarPresencasPorAtleta(Long idAtleta);
}
