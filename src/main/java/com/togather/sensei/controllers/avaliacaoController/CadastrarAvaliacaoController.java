package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.services.avaliacaoService.AvaliacaoPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao")
public class CadastrarAvaliacaoController {

    private final AvaliacaoPostService avaliacaoPostService;

    @PostMapping
    public ResponseEntity<AvaliacaoModel> cadastrarAvaliacaoModel(@RequestBody AvaliacaoModel avaliacaoModel) {
        try {
            avaliacaoModel = avaliacaoPostService.saveAvaliacao(avaliacaoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoModel);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}


