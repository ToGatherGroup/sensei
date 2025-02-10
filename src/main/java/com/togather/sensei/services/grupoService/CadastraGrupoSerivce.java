package com.togather.sensei.services.grupoService;

import com.togather.sensei.models.classificacoes.GrupoModel;
import org.springframework.stereotype.Service;

@Service
public interface CadastraGrupoSerivce {

    GrupoModel cadastrarGrupo(String nomeGrupo);

}
