package com.togather.sensei.services.grupoService.impl;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.CadastraGrupoSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraGrupoServiceImpl implements CadastraGrupoSerivce {

    private final GrupoRepository grupoRepository;

    @Override
    public GrupoModel cadastrarGrupo(GrupoModel grupoModel) {
        return grupoRepository.save(grupoModel);
    }
}
