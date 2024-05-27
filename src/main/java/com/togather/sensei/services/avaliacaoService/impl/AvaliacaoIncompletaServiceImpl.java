package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.DTO.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.DTO.avaliacao.ResponseIncommpletasDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoIncompletaServiceImpl implements AvaliacaoIncompletaService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ModelMapper mapper;

    @Override
    public ResponseIncommpletasDTO buscaAvaliacoesIncompletas() {

        List<AvaliacaoModel> listaAvaliacaoIncompleta= avaliacaoRepository.getAvaliacoesIncompletas();

        List<AvaliacaoDTO> listaAvaliacaoDTO= listarAvaliacoes(listaAvaliacaoIncompleta);
        LocalDate data = avaliacaoRepository.getDataAvaliacoesIncompletas();
        ResponseIncommpletasDTO response = new ResponseIncommpletasDTO(data, listaAvaliacaoDTO);
        return response;
    }


    private List<AvaliacaoDTO> listarAvaliacoes(List<AvaliacaoModel> listaAvaliacaoIncompleta){

        List<AvaliacaoDTO> listaAvaliacaoDTO= new ArrayList<>();

        for (AvaliacaoModel avaliacao: listaAvaliacaoIncompleta) {
            AvaliacaoDTO avaliacaoDTO= mapper.map(avaliacao,AvaliacaoDTO.class);
            ListaExerciciosDTO listaExerciciosDTO= mapper.map(avaliacao,ListaExerciciosDTO.class);


            avaliacaoDTO.setAtletaNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
            avaliacaoDTO.setExercicios(listaExerciciosDTO);
            listaAvaliacaoDTO.add(avaliacaoDTO);
        }

        return listaAvaliacaoDTO;
    }

}
