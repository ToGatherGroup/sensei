package com.togather.sensei.services.atletaService;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;

public interface AtletaPostService {

    AtletaModel saveAtleta(AtletaDTO atletaDTO);

    AtletaNewModel saveAtletaNew(AtletaDTO atletaDTO);
}
