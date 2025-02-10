package com.togather.sensei.services.atletaService.impl;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.FotoAtletaModel;
import com.togather.sensei.repositories.AtletaNewRepository;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import com.togather.sensei.services.fotoAtletaService.FotosAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtualizaAtletatServiceImpl implements AtualizaAtletatService {

    private final AtletaRepository atletaRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final AtletaNewRepository atletaNewRepository;
    private final FotosAtletaService fotosAtletaService;

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

    @Override
    public AtletaNewModel updateAtletaNew(AtletaDTO atletaDTO) {

        Optional<AtletaNewModel> atletaNewModel= atletaNewRepository.findById(atletaDTO.getId());
        if (atletaNewModel.isEmpty()) {
            throw new NotFoundException("Atleta informado não encontrado.");
        }

        AtletaNewModel model = atletaNewModel.get();

        if (!model.getIsAtivo()){
            Optional<AvaliacaoModel> avaliacao= avaliacaoRepository.getAvaliacaoIncompletaByAtleta(model.getId());
            avaliacao.ifPresent(avaliacaoRepository::delete);
        }

        FotoAtletaModel fotoAtletaModel = updateFotoAtleta(model, atletaDTO);

        model.setId(atletaDTO.getId());
        model.setNome(atletaDTO.getNome());
        model.setNascimento(atletaDTO.getNascimento());
        model.setSexo(atletaDTO.getSexo());
        model.setFaixa(atletaDTO.getFaixa());
        model.setEmail(atletaDTO.getEmail());
        model.setIsAtivo(atletaDTO.getIsAtivo());
        model.setFoto(fotoAtletaModel);

        return atletaNewRepository.save(model);
    }

    private FotoAtletaModel updateFotoAtleta(AtletaNewModel model, AtletaDTO atletaDTO) {
        FotoAtletaModel fotoAtletaModel = fotosAtletaService.getFotoAtleta(model.getFoto().getId());
        fotoAtletaModel.setFoto(atletaDTO.getFoto());
        return fotosAtletaService.createFotoAtleta(fotoAtletaModel);
    }
}