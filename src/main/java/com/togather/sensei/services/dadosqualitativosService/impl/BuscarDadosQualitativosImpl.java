package com.togather.sensei.services.dadosqualitativosService.impl;

import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosDTO;
import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.dadosqualitativosService.BuscarDadosQualitativosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarDadosQualitativosImpl implements BuscarDadosQualitativosService {

    private final AtletaRepository atletaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public DadosQualitativosResponseDTO buscaDadosQualitativos(long atleta_id) {
        DadosQualitativosResponseDTO resultado = new DadosQualitativosResponseDTO();
        String dadoCooper = avaliacaoRepository.resultadoClassifcacaoCooperPorAtleta(atleta_id);
        String dadoFlexao = avaliacaoRepository.resultadoClassificacaoFlexoesPorAtleta(atleta_id);
        String dadoVO2 = avaliacaoRepository.resultadoClassificacaoVO2PorAtleta(atleta_id);
        String dadoAbdominal = avaliacaoRepository.resultadoClassificacaoAbdominaisPorAtleta(atleta_id);

        AtletaModel atletaModel = atletaRepository.getReferenceById(atleta_id);
        int idade = calcularIdade(atletaModel.getNascimento());

        String dadoIMC = (idade <= 17) ? avaliacaoRepository.resultadoClassificacaoIMCAdolescentePorAtleta(atleta_id) : avaliacaoRepository.resultadoClassificacaoIMCPorAtleta(atleta_id);

        List<DadosQualitativosDTO> listaDadosQualitativos = new ArrayList<>();
        if (dadoCooper != null && !dadoCooper.isBlank())
            listaDadosQualitativos.add(new DadosQualitativosDTO("Cooper", dadoCooper));
        if (dadoFlexao != null && !dadoFlexao.isBlank())
            listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação Flexões", dadoFlexao));
        if (dadoVO2 != null && !dadoVO2.isBlank())
            listaDadosQualitativos.add(new DadosQualitativosDTO("Resultado VO2", dadoVO2));
        if (dadoAbdominal != null && !dadoAbdominal.isBlank())
            listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação Abdominal", dadoAbdominal));
        if (dadoIMC != null && !dadoIMC.isBlank())
            listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação IMC", dadoIMC));

        resultado.setDados(listaDadosQualitativos);
        return resultado;
    }

    public int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
