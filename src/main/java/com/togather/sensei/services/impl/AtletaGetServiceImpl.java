package com.togather.sensei.services.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.AtletaGetService;
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