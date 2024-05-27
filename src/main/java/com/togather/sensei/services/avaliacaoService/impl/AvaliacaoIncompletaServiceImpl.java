package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoIncompletaServiceImpl implements AvaliacaoIncompletaService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<AtletaIdNomeDTO> buscaAvaliacoesIncompletas(String exercicio) {

        List<AvaliacaoModel> listaAvaliacoes= avaliacaoRepository.getAvaliacoesIncompletas();
        List<AtletaIdNomeDTO> listaAvaliacaoIncompleta = compilarAtletas(listaAvaliacoes,exercicio);

        return listaAvaliacaoIncompleta;
    }

    private List<AtletaIdNomeDTO> compilarAtletas(List<AvaliacaoModel> listaAvaliacoes, String coluna){


        List<AtletaIdNomeDTO> incompletaDTOList= new ArrayList<>();
        switch (coluna){
            case "prancha":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getPrancha() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;

            case "abdominais":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getAbdominais() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;

            case "altura":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getAltura() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "impulsao_vertical":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getImpulsaoVertical() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;

            case "burpees":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getBurpees() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;

            case "flexoes":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getFlexoes() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "forca_isometrica_maos":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getForcaIsometricaMaos() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "peso":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getPeso() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "rm_terra":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getRmTerra() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "teste_de_lunge":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getTesteDeLunge() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
            case "cooper":
                for (AvaliacaoModel avaliacao: listaAvaliacoes) {
                    AtletaIdNomeDTO atleta= new AtletaIdNomeDTO();
                    if (avaliacao.getCooper() == null){
                        atleta.setNome(avaliacao.getAvaliacaoModelId().getAtletaModel().getNome());
                        atleta.setId(avaliacao.getAvaliacaoModelId().getAtletaModel().getId());
                        incompletaDTOList.add(atleta);
                    }
                }
                break;
        }

        return incompletaDTOList;
    }
}
