package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.DTO.atleta.AtletaDTO;

public interface BuscaCardAtletaByIdService {
    AtletaCardDTO findAtletaCardById(Long id);
}
