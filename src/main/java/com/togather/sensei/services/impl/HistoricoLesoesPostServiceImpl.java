package com.togather.sensei.services.impl;


import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.repositories.HistoricoLesoesRepository;
import com.togather.sensei.services.HistoricoLesoesPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoLesoesPostServiceImpl implements HistoricoLesoesPostService {
    private final HistoricoLesoesRepository historicoLesoesRepository;

    @Override
    public HistoricoLesoesModel savehistoricoLesoes(HistoricoLesoesModel historicoLesoesModel) {
       HistoricoLesoesModel model= historicoLesoesRepository.save(historicoLesoesModel);
        return model;
    }
}
