package com.togather.sensei.services.impl;

import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.repositories.HistoricoLesoesRepository;
import com.togather.sensei.services.BuscarHistoricoLesoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarHistoricoLesoesPorAtletaServiceImpl implements BuscarHistoricoLesoesPorAtletaService {

    private final HistoricoLesoesRepository repository;

    @Override
    public List<HistoricoLesoesModel> buscaHistoricoLesoes(long atleta_id) {
        return repository.buscarHistoricoDeLesoesPorAtletaId(atleta_id);
    }
}
