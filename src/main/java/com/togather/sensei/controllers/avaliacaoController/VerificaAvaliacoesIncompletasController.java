package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.services.avaliacaoService.VerificaAvaliacaoIncompletaService;
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
public class VerificaAvaliacoesIncompletasController {

    private final VerificaAvaliacaoIncompletaService verificaAvaliacaoIncompletasService;

    @GetMapping("/verificar_incompletas")
    public ResponseEntity<Boolean> verificaAvaliacoesIncompletas() {

        try {
            Boolean avaliacoesIncompletas = verificaAvaliacaoIncompletasService.verificarAvaliacoesIncompletas();

            return ResponseEntity.ok().body(avaliacoesIncompletas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
