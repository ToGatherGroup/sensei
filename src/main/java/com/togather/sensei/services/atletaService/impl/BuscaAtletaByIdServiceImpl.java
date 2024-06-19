package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAtletaByIdServiceImpl implements BuscaAtletaByIdService {

    private final AtletaRepository atletaRepository;

    @Override
    public AtletaModel findAtletaById(Long id) {
        Optional<AtletaModel> model = atletaRepository.findById(id);
        AtletaModel atletaModel = validarAtletaModel(model);
        return atletaModel;
    }

    private AtletaModel validarAtletaModel(Optional<AtletaModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Atleta não encontrado.");
        }
        return model.get();
    }

}