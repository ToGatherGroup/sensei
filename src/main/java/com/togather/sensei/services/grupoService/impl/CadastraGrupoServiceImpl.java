package com.togather.sensei.services.grupoService.impl;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.CadastraGrupoSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CadastraGrupoServiceImpl implements CadastraGrupoSerivce {

    private final GrupoRepository grupoRepository;

    @Override
    public GrupoModel cadastrarGrupo(String nomeGrupo) {

        GrupoModel grupo = grupoRepository.findByNome(nomeGrupo);
        GrupoModel grupoModel = new GrupoModel();

        if (Objects.isNull(grupo)) {
            grupoModel.setNome(nomeGrupo);
        }
        else  {
            throw new IllegalArgumentException("Grupo já cadastrado");
        }

        return grupoRepository.save(grupoModel);
    }
}
