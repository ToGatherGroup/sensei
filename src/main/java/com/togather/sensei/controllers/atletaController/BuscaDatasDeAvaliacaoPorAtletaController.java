package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.services.avaliacaoService.DatasDeAvaliacaoPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_por_data_por_atleta")

public class BuscaDatasDeAvaliacaoPorAtletaController {
    private final DatasDeAvaliacaoPorAtletaService datasDeAvaliacaoPorAtletaService;

    @GetMapping("{atletaId}")
    public ResponseEntity<List<Date>> buscaPorDataPorAtleta(@PathVariable Long atletaId) {
        try {
            List<Date> datasAvaliacoesPorAtleta = datasDeAvaliacaoPorAtletaService.buscarDatasAvaliacoesPorAtleta(atletaId);
            return ResponseEntity.ok().body(datasAvaliacoesPorAtleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
