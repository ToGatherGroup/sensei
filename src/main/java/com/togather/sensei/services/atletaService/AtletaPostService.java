package com.togather.sensei.services.atletaService;

import com.togather.sensei.dtos.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;

public interface AtletaPostService {

    AtletaModel saveAtleta(AtletaDTO atletaDTO);

//    AtletaNewModel saveAtletaNew(AtletaDTO atletaDTO);
}
