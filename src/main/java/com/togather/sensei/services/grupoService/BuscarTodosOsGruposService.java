package com.togather.sensei.services.grupoService;

import com.togather.sensei.models.classificacoes.GrupoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuscarTodosOsGruposService {

    List<GrupoModel> getAllGrupos();
}
