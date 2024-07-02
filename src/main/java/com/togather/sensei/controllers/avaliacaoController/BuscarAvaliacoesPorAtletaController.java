package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao")
public class BuscarAvaliacoesPorAtletaController {

    private final AvaliacoesPorAtletaService avaliacoesPorAtletaDataService;

    @GetMapping("/{atletaId}")
    public ResponseEntity<SeriesDTO> buscaAvaliacoesPorAtleta(@PathVariable Long atletaId) {
        try {
            SeriesDTO dto = avaliacoesPorAtletaDataService.getAvaliacoesPorAtleta(atletaId);
            return ResponseEntity.ok().body(dto);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}