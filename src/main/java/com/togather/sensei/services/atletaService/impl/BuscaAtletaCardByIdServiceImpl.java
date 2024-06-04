package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.repositories.CategoriaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import com.togather.sensei.services.atletaService.BuscaCardAtletaByIdService;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAtletaCardByIdServiceImpl implements BuscaCardAtletaByIdService {

    private final AtletaRepository atletaRepository;
    private final BuscaMedalhaService buscaMedalhaService;
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper mapper;

    @Override
    public AtletaCardDTO findAtletaCardById(Long id) {
        return gerarCard(id);
    }


    private AtletaModel validaAtleta(Optional<AtletaModel> optional){
        if (optional.isEmpty()) throw new NotFoundException("Atleta não encontrado");

        return optional.get();
    }

    private int calculaIdade(LocalDate nascimento){
        Period period = Period.between(nascimento, LocalDate.now());
        return period.getYears();
    }

    private AtletaCardDTO gerarCard(Long id){
        AtletaModel atleta= validaAtleta(atletaRepository.findById(id));
        List<MedalhaDTO> medalhaDTO= buscaMedalhaService.buscaMedalhas(id);
        Integer idade= calculaIdade(atleta.getNascimento());
        String categoria= categoriaRepository.gerarCategoria(idade);

        AtletaCardDTO card = mapper.map(atleta, AtletaCardDTO.class);
        card.setMedalhaDTO(medalhaDTO);
        card.setIdade(idade);
        card.setCategoria(categoria);

        return card;

    }

}