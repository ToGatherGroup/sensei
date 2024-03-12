package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtletaPutServiceImpl implements AtletaPutService {

    private final AtletaRepository atletaRepository;

    @Override
    public AtletaModel updateAtleta(AtletaModel atletaModel) {
        Optional<AtletaModel> model= atletaRepository.findById(atletaModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Atleta informado não encontrado.");
        }
        return atletaRepository.save(atletaModel);
    }
}