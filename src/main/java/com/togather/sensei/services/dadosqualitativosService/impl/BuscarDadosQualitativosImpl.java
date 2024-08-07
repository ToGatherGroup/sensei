package com.togather.sensei.services.dadosqualitativosService.impl;

import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosDTO;
import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.exceptions.NotFoundException;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscarDadosQualitativosImpl implements BuscarDadosQualitativosService {

    private final AtletaRepository atletaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public DadosQualitativosResponseDTO buscaDadosQualitativos(long atleta_id) {
        Optional<AtletaModel> optionalAtletaModel = atletaRepository.findById(atleta_id);
        if(optionalAtletaModel.isEmpty())
            throw new NotFoundException("Atleta com id " + atleta_id + " não encontrado!");

        AtletaModel atletaModel = optionalAtletaModel.get();

        int idade = calcularIdade(atletaModel.getNascimento());
        String dadoCooper = avaliacaoRepository.resultadoClassifcacaoCooperPorAtleta(atleta_id);
        String dadoFlexao = avaliacaoRepository.resultadoClassificacaoFlexoesPorAtleta(atleta_id);
        String dadoVO2 = avaliacaoRepository.resultadoClassificacaoVO2PorAtleta(atleta_id);
        String dadoAbdominal = avaliacaoRepository.resultadoClassificacaoAbdominaisPorAtleta(atleta_id);

        String dadoIMC = (idade <= 17) ?
                avaliacaoRepository.resultadoClassificacaoIMCAdolescentePorAtleta(atleta_id) :
                avaliacaoRepository.resultadoClassificacaoIMCPorAtleta(atleta_id);

        List<DadosQualitativosDTO> listaDadosQualitativos = new ArrayList<>();
        listaDadosQualitativos.add(new DadosQualitativosDTO("Cooper", dadoCooper));
        listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação Flexões", dadoFlexao));
        listaDadosQualitativos.add(new DadosQualitativosDTO("Resultado VO2", dadoVO2));
        listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação Abdominal", dadoAbdominal));
        listaDadosQualitativos.add(new DadosQualitativosDTO("Classificação IMC", dadoIMC));

        DadosQualitativosResponseDTO resultado = new DadosQualitativosResponseDTO();
        resultado.setDados(verificarNulos(listaDadosQualitativos));
        return resultado;
    }

    private List<DadosQualitativosDTO> verificarNulos(List<DadosQualitativosDTO> listaQualitativos){

        for (DadosQualitativosDTO dado: listaQualitativos) {
            if (dado.getResult()==null) dado.setResult("Não Aplicável");
        }
        return listaQualitativos;
    }

    public int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
