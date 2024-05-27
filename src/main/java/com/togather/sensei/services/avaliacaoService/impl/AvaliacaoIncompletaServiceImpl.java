package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoIncompletaServiceImpl implements AvaliacaoIncompletaService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ModelMapper mapper;

    @Override
    public List<AvaliacaoDTO> buscaAvaliacoesIncompletas() {

        List<AvaliacaoModel> listaAvaliacaoIncompleta= avaliacaoRepository.getAvaliacoesIncompletas();
        List<AvaliacaoDTO> listaAvaliacaoDTO= new ArrayList<>();
        for (AvaliacaoModel avaliacao: listaAvaliacaoIncompleta) {
            AvaliacaoDTO avaliacaoDTO= mapper.map(avaliacao,AvaliacaoDTO.class);
            avaliacaoDTO.setData(avaliacao.getAvaliacaoModelId().getData());
           listaAvaliacaoDTO.add(avaliacaoDTO);


        }

        return listaAvaliacaoDTO;
    }


}
