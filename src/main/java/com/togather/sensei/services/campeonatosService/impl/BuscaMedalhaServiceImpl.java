package com.togather.sensei.services.campeonatosService.impl;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaMedalhaServiceImpl implements BuscaMedalhaService {

    private final CampeonatosRepository campeonatosRepository;


    @Override
    public List<MedalhaDTO> buscaMedalhas(Long atletaId) {
        List<Object[]> campeonatos=  campeonatosRepository.listaMedalhas(atletaId);
        List<MedalhaDTO> listaMedalhas= new ArrayList<>();

        for (Object[] tupla: campeonatos) {
            String posicao= tupla[0].toString();
            String quantidade= tupla[1].toString();

            listaMedalhas.add(new MedalhaDTO(posicao,quantidade));

        }

        return listaMedalhas ;
    }
}
