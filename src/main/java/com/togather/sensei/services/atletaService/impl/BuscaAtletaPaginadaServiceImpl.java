package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaAtletaPaginadaServiceImpl implements BuscaAtletaPaginadaService {

    private final AtletaRepository atletaRepository;
    private final ModelMapper modelMapper;


    @Override
    public Page<AtletaIdNomeFotoDTO> buscaAtletas(Pageable pageable) {
       Page<AtletaModel> atletas= atletaRepository.findAll(pageable);
       List<AtletaIdNomeFotoDTO> atletasDto= new ArrayList<>();

        for (AtletaModel atleta: atletas) {
         AtletaIdNomeFotoDTO nomeFotoDTO= modelMapper.map(atleta, AtletaIdNomeFotoDTO.class);
         atletasDto.add(nomeFotoDTO);
        }

        Page<AtletaIdNomeFotoDTO> atletasPage = new PageImpl<>(atletasDto, pageable, atletas.getTotalElements());

        return atletasPage;
    }


}