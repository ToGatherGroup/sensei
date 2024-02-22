package com.togather.sensei.services;


import com.togather.sensei.DTO.AtletaDTO;

public interface AtletaGetByIdService {
    AtletaDTO findAtletaById(Long id);
}
