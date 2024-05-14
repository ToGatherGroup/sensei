package com.togather.sensei.services.atletaService;


import com.togather.sensei.models.AtletaModel;
import org.springframework.stereotype.Service;

@Service
public interface AtualizaAtletatService {
    AtletaModel updateAtleta(AtletaModel atletaModel);

    void updateStatusAtleta(Long id, Boolean status);

}
