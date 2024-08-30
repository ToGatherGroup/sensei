package com.togather.sensei.services.campeonatosService.impl;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.enums.PosicaoEnum;
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
        List<Object[]> campeonatos = campeonatosRepository.listaMedalhas(atletaId);

        List<MedalhaDTO> listaMedalhas= new ArrayList<>();

        for (Object[] tupla: campeonatos) {
            long quantidade=(Long) tupla[1];
            int index= Integer.parseInt(tupla[0].toString());
            String posicao= buscaDescricaoEnum(index);

            listaMedalhas.add(new MedalhaDTO(posicao, (int) quantidade));
        }

        return listaMedalhas ;
    }

    @Override
    public List<MedalhaDTO> buscaMedalhasComparativo(Long atletaId) {
        List<Object[]> campeonatos=  campeonatosRepository.listaMedalhas(atletaId);

        List<MedalhaDTO> medalhas = getMedalhasDefault();

        List<MedalhaDTO> listaMedalhasComparativo = new ArrayList<>();

        for (Object[] tupla: campeonatos) {
            long quantidade=(Long) tupla[1];
            int index= Integer.parseInt(tupla[0].toString());
            String posicao= buscaDescricaoEnum(index);
            listaMedalhasComparativo.add(new MedalhaDTO(posicao, (int) quantidade));
        }

        for (MedalhaDTO medalhaLista: listaMedalhasComparativo) {
            for (MedalhaDTO medalha: medalhas) {
                if (medalha.getPosicao().equals(medalhaLista.getPosicao())) {
                    medalha.setQuantidade(medalhaLista.getQuantidade());
                }
            }
        }

        return medalhas ;
    }

    private List<MedalhaDTO> getMedalhasDefault() {
        return List.of(
                new MedalhaDTO(PosicaoEnum.PRIMEIRO.getDescricao(), 0),
                new MedalhaDTO(PosicaoEnum.SEGUNDO.getDescricao(), 0),
                new MedalhaDTO(PosicaoEnum.TERCEIRO.getDescricao(), 0),
                new MedalhaDTO(PosicaoEnum.PARTICIPACAO.getDescricao(), 0)
        );
    }

    private String buscaDescricaoEnum(int index){

        PosicaoEnum[] lista = PosicaoEnum.values();

        return lista[index].getDescricao();
    }
}
