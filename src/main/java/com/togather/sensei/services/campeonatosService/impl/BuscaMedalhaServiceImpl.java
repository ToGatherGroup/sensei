package com.togather.sensei.services.campeonatosService.impl;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
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
            int index= Integer.parseInt(tupla[0].toString());

            String posicao= buscaDescricaoEnum(index);
            int quantidade=(int) tupla[1];

            listaMedalhas.add(new MedalhaDTO(posicao,quantidade));

        }

        return listaMedalhas ;
    }

    private String buscaDescricaoEnum(int index){

        PosicaoEnum[] lista = PosicaoEnum.values();
        String descricao = lista[index].getDescricao();

        return descricao;
    }
}
