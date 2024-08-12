package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.FotoAtletaModel;
import com.togather.sensei.repositories.AtletaNewRepository;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import com.togather.sensei.services.fotoAtletaService.FotosAtletaService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuscaAtletaPaginadaServiceImpl implements BuscaAtletaPaginadaService {

    private final FotosAtletaService fotosAtletaService;
    private final AtletaNewRepository atletaNewRepository;
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

    @Override
    public Page<AtletaIdNomeFotoDTO> buscaAtletasFotosCache(Pageable pageable) {
        Page<Tuple> atletasPage = atletaNewRepository.getDadosAtleta(pageable);

        List<FotoAtletaModel> allFotosAtleta = fotosAtletaService.getAllFotosAtleta();
        Map<Long, String> fotoMap = allFotosAtleta.stream()
                .collect(Collectors.toMap(FotoAtletaModel::getId, FotoAtletaModel::getFoto));

        List<AtletaIdNomeFotoDTO> atletasDto = atletasPage.stream()
                .map(tuple -> {
                    Long atletaId = tuple.get("id", Long.class);
                    String nome = tuple.get("nome", String.class);
                    Long fotoId = tuple.get("foto_id", Long.class);

                    return AtletaIdNomeFotoDTO.builder()
                            .id(atletaId)
                            .nome(nome)
                            .foto(fotoMap.get(fotoId))
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(atletasDto, pageable, atletasPage.getTotalElements());
    }
}