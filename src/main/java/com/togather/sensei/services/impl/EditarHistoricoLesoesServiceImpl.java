package com.togather.sensei.services.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.repositories.HistoricoLesoesRepository;
import com.togather.sensei.services.EditarHistoricoLesoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditarHistoricoLesoesServiceImpl implements EditarHistoricoLesoesService {

    private final HistoricoLesoesRepository repository;
    @Override
    public HistoricoLesoesModel updateHistoricoLesao(HistoricoLesoesModel model) {

        Optional<HistoricoLesoesModel> historicoLesoesOptional = repository.findById(model.getId());

        if (historicoLesoesOptional.isEmpty()) {
            throw new NotFoundException("Historico informado não encontrado.");
        }
        return repository.save(model);
    }
}
