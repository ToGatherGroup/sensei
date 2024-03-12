package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.AtletaDTO;

public interface AtletaGetByIdService {
    AtletaDTO findAtletaById(Long id);
}
