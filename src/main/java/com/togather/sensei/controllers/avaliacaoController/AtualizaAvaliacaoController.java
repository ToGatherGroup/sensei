package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.services.avaliacaoService.AtualizaAvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao")
public class AtualizaAvaliacaoController {

    private final AtualizaAvaliacaoService atualizaAtletatService;

    @PutMapping
    public ResponseEntity<Void> alteraAvaliacao(@RequestBody AvaliacaoModel avaliacaoModel){
        try {
            atualizaAtletatService.updateAvaliacao(avaliacaoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
