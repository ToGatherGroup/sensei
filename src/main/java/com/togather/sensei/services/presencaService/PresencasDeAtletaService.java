package com.togather.sensei.services.presencaService;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;

import java.time.LocalDate;

public interface PresencasDeAtletaService {
    PresencaAtletaDTO buscarPresencasPorAtleta(Long idAtleta, LocalDate inicio, LocalDate fim);
}
