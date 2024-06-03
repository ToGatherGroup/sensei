package com.togather.sensei.services.avaliacaoService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public interface DeletarAvaliacaoEspecificaService {

    void deletarAvaliacaoEspecifica(LocalDate data, Long atletaId);
}
