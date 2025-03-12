package com.togather.sensei.services.atletaService;


import com.togather.sensei.dtos.atleta.AtletaCardDTO;

public interface BuscaCardAtletaByIdService {
    AtletaCardDTO findAtletaCardById(Long id);
}
