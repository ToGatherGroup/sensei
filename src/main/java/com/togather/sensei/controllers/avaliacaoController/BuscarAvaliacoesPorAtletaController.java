package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.dtos.geral.SeriesDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacoesPorAtletaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes")
@Tag(name = "Avaliação", description = "Endpoints para gerenciamento de avaliações")
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