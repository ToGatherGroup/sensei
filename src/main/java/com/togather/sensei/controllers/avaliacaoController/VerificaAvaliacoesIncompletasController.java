package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.services.avaliacaoService.VerificaAvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas/verificar")
public class VerificaAvaliacoesIncompletasController {

    private final VerificaAvaliacaoIncompletaService verificaAvaliacaoIncompletasService;

    @GetMapping()
    public ResponseEntity<Boolean> verificaAvaliacoesIncompletas() {

        try {
            Boolean avaliacoesIncompletas = verificaAvaliacaoIncompletasService.verificarAvaliacoesIncompletas();

            return ResponseEntity.ok().body(avaliacoesIncompletas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
