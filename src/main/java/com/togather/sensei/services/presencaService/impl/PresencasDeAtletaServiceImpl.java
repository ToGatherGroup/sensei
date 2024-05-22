package com.togather.sensei.services.presencaService.impl;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.presencaService.PresencasDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PresencasDeAtletaServiceImpl implements PresencasDeAtletaService {

    private static final Integer NUMERAL_CEM = 100;
    private static final String PORCENTO = "%";

    private final PresencaRepository presencaRepository;
    private final AtletaRepository atletaRepository;
    @Override
    public PresencaAtletaDTO buscarPresencasPorAtleta(Long idAtleta, LocalDate inicio, LocalDate fim) {

        Optional<AtletaModel> optionalAtletaModel = atletaRepository.findById(idAtleta);
        AtletaModel atletaModel = validaListaPresenca(optionalAtletaModel);
        Long totalPresenca = presencaRepository.buscaPresenca(idAtleta, inicio, fim);
        Long totalDias = presencaRepository.buscaTotalDias(inicio, fim);
        String porcentagemPresenca = getPorcentagemPresenca(totalPresenca, totalDias);

        return PresencaAtletaDTO.builder()
                .id_atleta(atletaModel.getId())
                .nome(atletaModel.getNome())
                .totalPresenca(totalPresenca)
                .totalAusencia(totalDias - totalPresenca)
                .porcentagemPresenca(porcentagemPresenca)
                .build();
    }

    private AtletaModel validaListaPresenca(Optional<AtletaModel> atletaModel) {
        if (atletaModel.isEmpty()){
            throw new NotFoundException("Atleta não encontrado.");
        }
        AtletaModel atletaModelPresent = atletaModel.get();
        if (atletaModelPresent.getIsAtivo().equals(Boolean.FALSE)){
            throw new BusinessException("Atleta inativo.");
        }
        return atletaModelPresent;
    }

    private String getPorcentagemPresenca(Long totalPresenca, Long totalDias) {
        long porcentagem = Math.round((totalPresenca.doubleValue() / totalDias.doubleValue()) * NUMERAL_CEM);
        return Long.toString(porcentagem).concat(PORCENTO);
    }
}
