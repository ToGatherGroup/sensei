package com.togather.sensei.services.campeonatosService;

import com.togather.sensei.models.CampeonatosDisputadosModel;
import org.springframework.stereotype.Service;

@Service

public interface CadastraCampeonatoService {

    CampeonatosDisputadosModel salvaCampeonato(CampeonatosDisputadosModel campeonatosDisputadosModel);

}
