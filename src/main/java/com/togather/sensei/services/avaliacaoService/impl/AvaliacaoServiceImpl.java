package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AvaliacaoServiceImpl implements AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    @Override
    public List<AvaliacaoIncompletaDTO> buscaAvaliacoesIncompletas(String exercicio) {

        Specification<AvaliacaoModel> spec = getModelSpecification(exercicio);

        List<AvaliacaoModel> avaliacoesIncompletas = avaliacaoRepository.findAll(spec);

        List<AvaliacaoModel> avaliacoesIncompletasComAtletaAtivo = getAvaliacoesIncompletasAtletasAtivos(avaliacoesIncompletas);

        List<AvaliacaoIncompletaDTO> avaliacaoIncompletaDTOList = new ArrayList<>();
        for (AvaliacaoModel avaliacaoModel : avaliacoesIncompletasComAtletaAtivo) {
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
                    .impulsaoVertical(avaliacaoModel.getImpulsaoVertical())
                    .build());
        }
        return avaliacaoIncompletaDTOList;
    }

    private List<AvaliacaoModel> getAvaliacoesIncompletasAtletasAtivos(List<AvaliacaoModel> avaliacoesIncompletas) {
        List<AvaliacaoModel> avaliacoesIncompletasComAtletaAtivo = new ArrayList<>();
        for (AvaliacaoModel avaliacao : avaliacoesIncompletas){
            boolean isAtivo =
                    avaliacao.getAvaliacaoModelId().getAtletaModel().getIsAtivo() != null
                            ? avaliacao.getAvaliacaoModelId().getAtletaModel().getIsAtivo()
                            : false;
            if (isAtivo){
                avaliacoesIncompletasComAtletaAtivo.add(avaliacao);
            }
        }
        return avaliacoesIncompletasComAtletaAtivo;
    }

    private static Specification<AvaliacaoModel> getModelSpecification(String exercicio) {
        Map<String, Specification<AvaliacaoModel>> specificationMap = new HashMap<>();
        specificationMap.put("prancha", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("prancha")));
        specificationMap.put("flexoes", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("flexoes")));
        specificationMap.put("abdominais", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("abdominais")));
        specificationMap.put("burpees", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("burpees")));
        specificationMap.put("cooper", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("cooper")));
        specificationMap.put("rmTerra", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("rmTerra")));
        specificationMap.put("forcaIsometricaMaos", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("forcaIsometricaMaos")));
        specificationMap.put("testeDeLunge", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("testeDeLunge")));
        specificationMap.put("impulsaoVertical", (root, query, criteriaBuilder) -> criteriaBuilder.isNull(root.get("impulsaoVertical")));

        return specificationMap.get(exercicio);
    }
}

