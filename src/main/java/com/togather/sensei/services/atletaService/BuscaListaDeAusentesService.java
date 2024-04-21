package com.togather.sensei.services.atletaService;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;

import java.util.List;

public interface BuscaListaDeAusentesService
{
    List<AtletaIdNomeDTO> getListaDeAusentes();
}
