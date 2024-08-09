package com.togather.sensei.services.campeonatosService.impl;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.BuscaListaCampeonatoPorAtletaIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaListaCampeonatoPorAtletaIdServiceImpl implements BuscaListaCampeonatoPorAtletaIdService {

    private final CampeonatosRepository campeonatosRepository;

    @Override
    public List<ListaCampeonatoDTO> listaCampeonatosPorAtletaId(Long atleta_id) {
        List<CampeonatosDisputadosModel> campeonatos = campeonatosRepository.listaCampeonatosPorAtletaId(atleta_id);
        List<ListaCampeonatoDTO> listaCampeonatos = new ArrayList<>();

        for (CampeonatosDisputadosModel tupla : campeonatos) {
            String nome = tupla.getNome();
            PosicaoEnum posicaoDescricao = tupla.getPosicaoPodium();
            LocalDate data = tupla.getData();

            listaCampeonatos.add(new ListaCampeonatoDTO(
                    nome,
                    posicaoDescricao,
                    data
            ));
        }
        return listaCampeonatos;
    }
}
