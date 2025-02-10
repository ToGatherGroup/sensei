package com.togather.sensei.services.grupoService.impl;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.BuscarTodosOsGruposService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodosOsGruposServiceImpl implements BuscarTodosOsGruposService {

    private final GrupoRepository grupoRepository;

    @Override
    public List<GrupoModel> getAllGrupos() {
        return grupoRepository.findAll();
    }
}
