package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.services.avaliacaoService.AvaliacaoPorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacao/datas")
public class BuscarDatasDeAvaliacaoController {

    private final AvaliacaoPorDataService avaliacaoPorDataService;

    @GetMapping()
    public ResponseEntity<List<String>> buscaDatasDeAvaliacao() {
        try {
            List<String> datas = avaliacaoPorDataService.buscaAvaliacoes();
            return ResponseEntity.ok().body(datas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
