package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.services.avaliacaoService.BuscarAvaliacaoPorAtletaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao")

public class BuscarAvaliacoesPorAtletaDataController {

    private final BuscarAvaliacaoPorAtletaDataService buscarAvaliacaoPorAtletaDataService;

    @GetMapping("{atletaId}/{data}")
    public ResponseEntity<ResponseBuscaAvaliacaoDTO> buscarAvaliacao(@PathVariable Long atletaId, @PathVariable LocalDate data){
        ResponseBuscaAvaliacaoDTO avaliacao = buscarAvaliacaoPorAtletaDataService.findAvaliacao(atletaId,data);

        return ResponseEntity.ok().body(avaliacao);
    }
}
