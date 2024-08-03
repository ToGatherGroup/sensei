package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtualizaAtletatServiceImpl implements AtualizaAtletatService {

    private final AtletaRepository atletaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public AtletaModel updateAtleta(AtletaModel atletaModel) {
        if (!atletaModel.getIsAtivo()){
           Optional<AvaliacaoModel> avaliacao= avaliacaoRepository.getAvaliacaoIncompletaByAtleta(atletaModel.getId());
            avaliacao.ifPresent(avaliacaoRepository::delete);
        }
        Optional<AtletaModel> model= atletaRepository.findById(atletaModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Atleta informado não encontrado.");
        }
        return atletaRepository.save(atletaModel);
    }

    @Override
    public void updateStatusAtleta(Long id, Boolean status) {

        Optional<AtletaModel> model= atletaRepository.findById(id);
        if (model.isEmpty())
            throw new NotFoundException("Atleta informado não encontrado.");

        model.get().setIsAtivo(status);

        AtletaModel atletaModel=model.get();

        atletaRepository.save(atletaModel);
    }


}