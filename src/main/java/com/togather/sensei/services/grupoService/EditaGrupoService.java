package com.togather.sensei.services.grupoService;

import com.togather.sensei.models.classificacoes.GrupoModel;
import org.springframework.stereotype.Service;

@Service
public interface EditaGrupoService {

    GrupoModel updateGrupo(GrupoModel grupoModel);

    void updateStatusGrupo(Long id, boolean status);
}
