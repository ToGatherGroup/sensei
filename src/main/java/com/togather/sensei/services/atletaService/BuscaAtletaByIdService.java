package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaDTO;

public interface BuscaAtletaByIdService {
    AtletaDTO findAtletaById(Long id);
}
