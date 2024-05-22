package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtualizaAtletatServiceImpl implements AtualizaAtletatService {

    private final AtletaRepository atletaRepository;

    @Override
    public AtletaModel updateAtleta(AtletaModel atletaModel) {
        boolean exists = atletaRepository.existsById(atletaModel.getId());
        if (!exists) {
            throw new NotFoundException("Atleta informado não encontrado.");
        }
        return atletaRepository.save(atletaModel);
    }

    @Override
    public void updateStatusAtleta(Long id, Boolean status) {

        Optional<AtletaModel> model = atletaRepository.findById(id);
        if (model.isEmpty()) {
            throw new NotFoundException("Atleta informado não encontrado.");
        }
        AtletaModel atletaModel = model.get();
        atletaModel.setIsAtivo(status);
        atletaRepository.save(atletaModel);
    }
}