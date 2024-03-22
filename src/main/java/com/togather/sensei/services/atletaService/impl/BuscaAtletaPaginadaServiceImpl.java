package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscaAtletaPaginadaServiceImpl implements BuscaAtletaPaginadaService {

    private final AtletaRepository atletaRepository;

    @Override
    public Page<AtletaModel> buscaAtletas(Pageable pageable) {



        return atletaRepository.findAll(pageable);
    }


}