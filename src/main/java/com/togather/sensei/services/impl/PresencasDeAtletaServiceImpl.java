package com.togather.sensei.services.impl;

import com.togather.sensei.DTO.PresencaAtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.PresencaModel;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.PresencasDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PresencasDeAtletaServiceImpl implements PresencasDeAtletaService {

    private static final Integer NUMERAL_CEM = 100;
    private static final String PORCENTO = "%";

    private final PresencaRepository presencaRepository;
    @Override
    public PresencaAtletaDTO buscarPresencasPorAtleta(Long idAtleta) {

        AtletaModel atletaModel = new AtletaModel();
        List<LocalDate> datasPresenca = new ArrayList<>();

        List<PresencaModel> list = presencaRepository.buscaPresencasPorAtleta(idAtleta);

        validaListaPresenca(list);

        for (PresencaModel model : list){
            atletaModel = model.getAtletaModel();
            datasPresenca.add(model.getData());
        }

        return PresencaAtletaDTO.builder()
                .id_atleta(atletaModel.getId())
                .nome(atletaModel.getNome())
                .porcentagemPresenca(getPorcentagemPresenca(idAtleta))
                .datasPresenca(datasPresenca)
                .build();
    }

    private void validaListaPresenca(List<PresencaModel> list) {
        if (list.isEmpty()){
            throw new NotFoundException("Atleta não encontrado.");
        }
    }

    private String getPorcentagemPresenca(Long idAtleta) {
        Double totalDias = presencaRepository.getTotalDeDias();
        Double diasDoAtleta = presencaRepository.getDiasDoAtleta(idAtleta);
        Double porcentagem = (diasDoAtleta / totalDias) * NUMERAL_CEM;
        return porcentagem.toString().concat(PORCENTO);
    }
}
