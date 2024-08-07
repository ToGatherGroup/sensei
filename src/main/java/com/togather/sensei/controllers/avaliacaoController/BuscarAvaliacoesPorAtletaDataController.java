package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.services.avaliacaoService.BuscarAvaliacaoPorAtletaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao")

public class BuscarAvaliacoesPorAtletaDataController {

    private final BuscarAvaliacaoPorAtletaDataService buscarAvaliacaoPorAtletaDataService;

    @GetMapping("{atletaId}/{data}")
    public ResponseEntity<ResponseBuscaAvaliacaoDTO> buscarAvaliacao(@PathVariable Long atletaId, @PathVariable LocalDate data) {
        try {
            ResponseBuscaAvaliacaoDTO avaliacao = buscarAvaliacaoPorAtletaDataService.findAvaliacao(atletaId, data);

            return ResponseEntity.ok().body(avaliacao);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
