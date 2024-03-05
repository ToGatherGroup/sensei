package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.AtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.AtletaGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtletaGetByIdServiceImpl implements AtletaGetByIdService {

    private final AtletaRepository atletaRepository;

    @Override
    public AtletaDTO findAtletaById(Long id) {
        Optional<AtletaModel> model = atletaRepository.findById(id);
        AtletaModel atletaModel = validarAtletaModel(model);
        return mapearAtletaDto(atletaModel);
    }

    private AtletaModel validarAtletaModel(Optional<AtletaModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Atleta não encontrado.");
        }
        return model.get();
    }

    private AtletaDTO mapearAtletaDto(AtletaModel model) {
        return AtletaDTO.builder()
                .nome((model.getNome() != null ? model.getNome() : null))
                .nascimento((model.getNascimento() != null ? model.getNascimento() : null))
                .sexo((model.getSexo() != null ? model.getSexo() : null))
                .peso((model.getPeso() != null ? model.getPeso() : null))
                .altura((model.getAltura() != null ? model.getAltura() : null))
                .categoria((model.getCategoria() != null ? model.getCategoria() : null))
                .faixa((model.getFaixa() != null ? model.getFaixa() : null))
                .foto((model.getFoto() != null ? model.getFoto() : null))
                .email((model.getEmail() != null ? model.getEmail() : null))
                .build();
    }
}