package com.togather.sensei.services.lesaoService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.EditarLesaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditarLesaoServiceImpl implements EditarLesaoService {

    private final LesaoRepository repository;
    @Override
    public LesaoModel updateHistoricoLesao(LesaoModel model) {

        Optional<LesaoModel> historicoLesoesOptional = repository.findById(model.getId());

        if (historicoLesoesOptional.isEmpty()) {
            throw new NotFoundException("Historico informado não encontrado.");
        }
        return repository.save(model);
    }
}
