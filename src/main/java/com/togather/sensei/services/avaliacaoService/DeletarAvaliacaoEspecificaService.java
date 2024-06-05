package com.togather.sensei.services.avaliacaoService;

import java.time.LocalDate;


public interface DeletarAvaliacaoEspecificaService {

    void deletarAvaliacaoEspecifica(LocalDate data, Long atletaId);
}
