package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoMesmaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeletarAvaliacaoMesmaDataImpl implements DeletarAvaliacaoMesmaDataService {
    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public void deletaAvaliacaoMesmaData(LocalDate data) {
        List<AvaliacaoModel> listaAvaliacaoMesmaData = avaliacaoRepository.buscaAvaliacaoMesmaData(data);

        if (listaAvaliacaoMesmaData.isEmpty()) {
            throw new NotFoundException("Nenhuma avaliação encontrada para a data fornecida.");
        }

        for (AvaliacaoModel avaliacaoModel : listaAvaliacaoMesmaData) {
            avaliacaoRepository.delete(avaliacaoModel);
        }
    }

}
