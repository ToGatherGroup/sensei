package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAtletaByIdServiceImpl implements BuscaAtletaByIdService {

    private final AtletaRepository atletaRepository;

    @Override
    public AtletaDTO findAtletaById(Long id) {
        Optional<AtletaModel> model = atletaRepository.findById(id);
        AtletaModel atletaModel = validarAtletaModel(model);
        return mapearAtletaDto(atletaModel);
    }

    private AtletaModel validarAtletaModel(Optional<AtletaModel> atletaModel) {
        if (atletaModel.isEmpty()){
            throw new NotFoundException("Atleta não encontrado.");
        }
        return atletaModel.get();
    }

    private AtletaDTO mapearAtletaDto(AtletaModel model) {
        return AtletaDTO.builder()
                .nome((model.getNome() != null ? model.getNome() : null))
                .nascimento((model.getNascimento() != null ? model.getNascimento() : null))
                .sexo((model.getSexo() != null ? model.getSexo() : null))
                .peso((model.getPeso() != null ? model.getPeso() : null))
                .altura((model.getAltura() != null ? model.getAltura() : null))
                .faixa((model.getFaixa() != null ? model.getFaixa() : null))
                .foto((model.getFoto() != null ? model.getFoto() : null))
                .email((model.getEmail() != null ? model.getEmail() : null))
                .build();
    }
}