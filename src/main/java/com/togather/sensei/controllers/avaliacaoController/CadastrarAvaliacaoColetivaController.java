package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.services.avaliacaoService.AvaliacaoColetivaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaocoletiva")
public class CadastrarAvaliacaoColetivaController {

    private final AvaliacaoColetivaService avaliacaoColetivaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarAvaliacaoColetiva(){
        try {
            avaliacaoColetivaService.cadastrarAvaliacaoColetiva();
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
