package com.togather.sensei.services.atletaService;


import com.togather.sensei.dtos.atleta.AtletaIdNomeDTO;

import java.time.LocalDate;
import java.util.List;

public interface BuscaAtletaPorDataAvaliacaoService {
    List<AtletaIdNomeDTO> findAllAtletasbyData(LocalDate dataAvaliacao);
}
