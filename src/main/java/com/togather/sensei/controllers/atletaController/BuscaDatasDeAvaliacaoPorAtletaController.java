package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.services.avaliacaoService.DatasDeAvaliacaoPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_por_data_por_atleta")

public class BuscaDatasDeAvaliacaoPorAtletaController {
    private final DatasDeAvaliacaoPorAtletaService datasDeAvaliacaoPorAtletaService;

    @GetMapping("{atletaId}")
    public ResponseEntity<List<Date>> buscaPorDataPorAtleta(@PathVariable Long atletaId){
        return ResponseEntity.ok().body(datasDeAvaliacaoPorAtletaService.buscarDatasAvaliacoesPorAtleta(atletaId));
    }


}
