package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.AtletaDTO;
import com.togather.sensei.DTO.AtletaIdNomeFotoDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaGetByIdService;
import com.togather.sensei.services.atletaService.BuscaAtletaByNomePaginadaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAtletaByNomePaginadaServiceImpl implements BuscaAtletaByNomePaginadaService {

    private final AtletaRepository atletaRepository;
    private final ModelMapper mapper;


    @Override
    public Page<AtletaModel> buscaNome(String nome,Pageable pageable) {
        List<AtletaIdNomeFotoDTO> listaDto= new ArrayList<>();
        Page<AtletaModel> lista= atletaRepository.buscaPorNome(nome, pageable);

        for (AtletaModel atletaModel:lista) {
            AtletaIdNomeFotoDTO atletaDto= mapper.map(atletaModel, AtletaIdNomeFotoDTO.class);
            listaDto.add(atletaDto);
        }

        Page page= new PageImpl(listaDto,pageable, listaDto.size());

        return page;
    }
}