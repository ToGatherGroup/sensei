package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.AtualizaAvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AtualizaAvaliacaoServiceImpl implements AtualizaAvaliacaoService {

    private final AtletaRepository atletaRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public void updateAvaliacao(AvaliacaoModel avaliacaoModel) {

      AvaliacaoModel avaliacaoEncontrada = validaAvaliacao(avaliacaoModel.getAvaliacaoModelId());
      avaliacaoEncontrada = modelMapper.map(avaliacaoModel,AvaliacaoModel.class);

      avaliacaoRepository.save(avaliacaoEncontrada);
    }

    private AvaliacaoModel validaAvaliacao(AvaliacaoModelId id){
        Optional<AvaliacaoModel> avaliacao = avaliacaoRepository.findById(id);
       if (avaliacao.isPresent()){
           return avaliacao.get();
       } else throw new RuntimeException("Avaliação não encontrada");

    }
}