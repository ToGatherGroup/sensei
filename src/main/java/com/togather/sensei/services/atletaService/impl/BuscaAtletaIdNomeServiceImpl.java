package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import com.togather.sensei.services.atletaService.BuscaAtletaIdNomeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAtletaIdNomeServiceImpl implements BuscaAtletaIdNomeService {

    private final AtletaRepository atletaRepository;
    private final ModelMapper mapper;

    @Override
    public List<AtletaIdNomeDTO> findAtletaIdNome() {
        List<AtletaModel> modelList= atletaRepository.findAll();
        List<AtletaIdNomeDTO> listAtletaIdNomeDTO= new ArrayList<>();

        for (AtletaModel model: modelList) {
          AtletaIdNomeDTO atletaDTO = mapper.map(model, AtletaIdNomeDTO.class);
          listAtletaIdNomeDTO.add(atletaDTO);
        }
        return listAtletaIdNomeDTO;
    }


}