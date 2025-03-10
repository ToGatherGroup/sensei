package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas")
@Tag(name = "Avaliação", description = "Endpoints para gerenciamento de avaliações")
public class BuscarAvaliacoesIncompletasController {

    private final AvaliacaoIncompletaService avaliacaoIncompletaService;

    @GetMapping()
    public ResponseEntity<ResponseAvaliacoesIncompletasDTO> buscaAvaliacoesIncompletas() {
        try {
            ResponseAvaliacoesIncompletasDTO avaliacoesIncompletas = avaliacaoIncompletaService.buscaAvaliacoesIncompletas();
            return ResponseEntity.ok().body(avaliacoesIncompletas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
