package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BuscaAtletaPorDataAvaliacaoService {
    List<AtletaIdNomeDTO> findAtletasbyData(LocalDate dataAvaliacao);
}
