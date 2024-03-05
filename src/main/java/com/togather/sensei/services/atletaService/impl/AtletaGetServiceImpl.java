package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtletaGetServiceImpl implements AtletaGetService {

    private final AtletaRepository atletaRepository;

    @Override
    public List<AtletaModel> buscaAtletas() {
        return atletaRepository.findAll();
    }
}