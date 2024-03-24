package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;

import java.util.List;

public interface BuscaAtletaIdNomeService {
    List<AtletaIdNomeDTO> findAtletaIdNome();
}
