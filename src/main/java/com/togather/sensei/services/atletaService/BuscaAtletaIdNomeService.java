package com.togather.sensei.services.atletaService;


import com.togather.sensei.dtos.atleta.AtletaIdNomeDTO;

import java.util.List;

public interface BuscaAtletaIdNomeService {
    List<AtletaIdNomeDTO> findAtletaIdNome();
}
