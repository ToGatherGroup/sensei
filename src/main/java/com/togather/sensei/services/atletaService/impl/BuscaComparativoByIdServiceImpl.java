package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaCardComparativoDTO;
import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.BuscaComparativoAtletaByIdService;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacoesPorAtletaServiceImpl;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaComparativoByIdServiceImpl implements BuscaComparativoAtletaByIdService {

    private final AtletaRepository atletaRepository;
    private final BuscaMedalhaService buscaMedalhaService;
    private final AvaliacoesPorAtletaServiceImpl avaliacoesService;
    private final AvaliacaoRepository avaliacaoRepository;


    @Override
    public AtletaCardComparativoDTO findAtletaCardById(Long id) {

        return gerarCard(id);
    }

    private Integer calculaIdade(LocalDate nascimento){
        Period period = Period.between(nascimento, LocalDate.now());
        return period.getYears();
    }

    private AtletaCardComparativoDTO gerarCard(Long id){

        AtletaModel atleta = validaAtleta(atletaRepository.findById(id));
        AvaliacaoModel avaliacao = avaliacaoRepository.getLastAvaliacaoByAtleta(id);

         String foto = atleta.getFoto();
         String nome = atleta.getNome();
         Double peso = avaliacao.getPeso();
         Double altura = avaliacao.getAltura();
         Integer idade = calculaIdade(atleta.getNascimento());
         String faixa = atleta.getFaixa();
         List<MedalhaDTO> medalhaDTO = buscaMedalhaService.buscaMedalhas(id);
         SeriesDTO valencia = avaliacoesService.getAvaliacoesPorAtleta(id);

        return new AtletaCardComparativoDTO(nome,peso,altura, idade, faixa, medalhaDTO,valencia, foto);

    }

    private AtletaModel validaAtleta(Optional<AtletaModel> optional){
        if (optional.isEmpty()) throw new NotFoundException("Atleta não encontrado");

        return optional.get();
    }

}