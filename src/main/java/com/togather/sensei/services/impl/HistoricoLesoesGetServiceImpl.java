package com.togather.sensei.services.impl;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.HistoricoLesoesRepository;
import com.togather.sensei.services.HistoricoLesoesGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoricoLesoesGetServiceImpl implements HistoricoLesoesGetService {
    private final HistoricoLesoesRepository historicoRepository;
    private final AtletaRepository atletaRepository;

    @Override
    public List<HistoricoLesoesModel> buscaHistoricoLesoes(long id) {
        Optional<AtletaModel> atleta = atletaRepository.findById(id);
        return historicoRepository.findAllByAtletaModel(atleta.get());
    }
}
