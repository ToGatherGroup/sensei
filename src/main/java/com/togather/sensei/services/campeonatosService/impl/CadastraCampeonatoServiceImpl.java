package com.togather.sensei.services.campeonatosService.impl;

import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.CadastraCampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraCampeonatoServiceImpl implements CadastraCampeonatoService {

    private final CampeonatosRepository campeonatosRepository;

    @Override
    public CampeonatosDisputadosModel salvaCampeonato(CampeonatosDisputadosModel campeonatosDisputadosModel) {

        return campeonatosRepository.save(campeonatosDisputadosModel);
    }
}
