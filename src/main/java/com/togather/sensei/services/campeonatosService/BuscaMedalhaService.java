package com.togather.sensei.services.campeonatosService;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuscaMedalhaService {

    List<MedalhaDTO> buscaMedalhas(Long atletaId);

    List<MedalhaDTO> buscaMedalhasComparativo(Long atletaId);
}
