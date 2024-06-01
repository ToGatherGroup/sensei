package com.togather.sensei.services.avaliacaoService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface DatasDeAvaliacaoPorAtletaService {


        List<Date> buscarDatasAvaliacoesPorAtleta (Long atletaId);

    }
