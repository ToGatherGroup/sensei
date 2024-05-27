package com.togather.sensei.services.avaliacaoService.impl;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoEspecificaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeletarAvaliacaoEspecificaImpl implements DeletarAvaliacaoEspecificaService {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public void deletarAvaliacaoEspecifica(LocalDate data, Long atletaId){
        AvaliacaoModel avaliacaoEspecifica = avaliacaoRepository.buscaListaAvaliacaoAtletaData(data, atletaId);

        if (avaliacaoEspecifica == null) {
            throw new NotFoundException("Nenhuma avaliação encontrada para a data e atleta fornecido.");
        }

        avaliacaoRepository.delete(avaliacaoEspecifica);
        }
}

