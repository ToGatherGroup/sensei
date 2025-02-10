package com.togather.sensei.services.atletaService;


import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;
import org.springframework.stereotype.Service;

@Service
public interface AtualizaAtletatService {
    AtletaModel updateAtleta(AtletaModel atletaModel);

    void updateStatusAtleta(Long id, Boolean status);

    AtletaNewModel updateAtletaNew(AtletaDTO atletaDTO);
}
