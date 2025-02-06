package com.togather.sensei.services.grupoService.impl;


import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.EditaGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EditaGrupoServiceImpl implements EditaGrupoService {

    private final GrupoRepository grupoRepository;

    @Override
    public GrupoModel updateGrupo(GrupoModel grupoModel) {
        Optional<GrupoModel> model = grupoRepository.findById(grupoModel.getId());
        if (model.isEmpty()) {
            throw new NotFoundException("Grupo informado não encontrado.");
        }
        return grupoRepository.save(grupoModel);
    }

    @Override
    public void updateStatusGrupo(Long id, boolean status) {
        Optional<GrupoModel> model = grupoRepository.findById(id);
        if (model.isEmpty())
            throw new NotFoundException("Grupo informado não encontrado.");

        model.get().setAtivo(status);

        GrupoModel grupoModel = model.get();

        grupoRepository.save(grupoModel);
    }

}
