package com.togather.sensei.services.campeonatosService;

import com.togather.sensei.DTO.MedalhaDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public interface BuscaMedalhaService {

    List<MedalhaDTO> buscaMedalhas(Long atletaId);
}
