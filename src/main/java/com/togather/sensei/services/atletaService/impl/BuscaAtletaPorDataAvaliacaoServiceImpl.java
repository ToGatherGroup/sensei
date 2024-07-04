package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaPorDataAvaliacaoService;
import com.togather.sensei.services.atletaService.BuscaListaDeAusentesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaAtletaPorDataAvaliacaoServiceImpl implements BuscaAtletaPorDataAvaliacaoService
{
    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<AtletaIdNomeDTO> findAllAtletasbyData(LocalDate dataAvaliacao) {

        List<AvaliacaoModel> listaAvaliacoes = avaliacaoRepository.buscaAvaliacaoMesmaData(dataAvaliacao);
        List<AtletaIdNomeDTO> listaAtletasPorData = new ArrayList<>();

        for (AvaliacaoModel avaliacao: listaAvaliacoes) {
            AtletaModel atletaModel= avaliacao.getAvaliacaoModelId().getAtletaModel();
            AtletaIdNomeDTO atleta = new AtletaIdNomeDTO(atletaModel.getId(),atletaModel.getNome());
            listaAtletasPorData.add(atleta);
        }
        return listaAtletasPorData;
    }
}
