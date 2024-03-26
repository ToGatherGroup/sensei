package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaByNomePaginadaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaAtletaByNomePaginadaServiceImpl implements BuscaAtletaByNomePaginadaService {

    private final AtletaRepository atletaRepository;
    private final ModelMapper mapper;


    @Override
    public Page<AtletaIdNomeFotoDTO> buscaNome(String nome,Pageable pageable) {
        List<AtletaIdNomeFotoDTO> listaDto= new ArrayList<>();
        Page<AtletaModel> lista= atletaRepository.buscaPorNome(nome, pageable);

        for (AtletaModel atletaModel:lista) {
            AtletaIdNomeFotoDTO atletaDto= mapper.map(atletaModel, AtletaIdNomeFotoDTO.class);
            listaDto.add(atletaDto);
        }

        Page page= new PageImpl(listaDto,pageable, lista.getTotalElements());

        return page;
    }
}