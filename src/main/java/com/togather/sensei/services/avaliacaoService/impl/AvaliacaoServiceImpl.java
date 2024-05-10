package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoServiceImpl implements AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    @Override
    public List<AvaliacaoIncompletaDTO> buscaAvaliacoesIncompletas() {

        List<AvaliacaoModel> avaliacoesIncompletas = avaliacaoRepository.getAvaliacoesIncompletas();

        List<AvaliacaoIncompletaDTO> avaliacaoIncompletaDTOList = new ArrayList<>();
        for (AvaliacaoModel avaliacaoModel : avaliacoesIncompletas){
            avaliacaoIncompletaDTOList.add(AvaliacaoIncompletaDTO.builder()
                            .dataAvaliacao(avaliacaoModel.getAvaliacaoModelId().getData())
                            .idAtleta(avaliacaoModel.getAvaliacaoModelId().getAtletaModel().getId())
                            .nomeAtleta(avaliacaoModel.getAvaliacaoModelId().getAtletaModel().getNome())
                            .peso(avaliacaoModel.getPeso())
                            .altura(avaliacaoModel.getAltura())
                            .prancha(avaliacaoModel.getPrancha())
                            .flexoes(avaliacaoModel.getFlexoes())
                            .abdominais(avaliacaoModel.getAbdominais())
                            .burpees(avaliacaoModel.getBurpees())
                            .cooper(avaliacaoModel.getCooper())
                            .rmTerra(avaliacaoModel.getRmTerra())
                            .forcaIsometricaMaos(avaliacaoModel.getForcaIsometricaMaos())
                            .testeDeLunge(avaliacaoModel.getTesteDeLunge())
                            .build());
        }
        return avaliacaoIncompletaDTOList;
    }
}
