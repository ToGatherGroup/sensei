package com.togather.sensei.services.lesaoService.impl;

import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.BuscarHistoricoLesoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarLesaoPorAtletaServiceImpl implements BuscarHistoricoLesoesPorAtletaService {

    private final LesaoRepository repository;

    @Override
    public List<LesaoModel> buscaHistoricoLesoes(long atleta_id) {
        return repository.buscarHistoricoDeLesoesPorAtletaId(atleta_id);
    }
}
