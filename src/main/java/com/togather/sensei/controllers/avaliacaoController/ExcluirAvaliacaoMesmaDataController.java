package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoMesmaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_mesma_data")
public class ExcluirAvaliacaoMesmaDataController {
    private final DeletarAvaliacaoMesmaDataService deletarAvaliacaoMesmaDataService;

    @DeleteMapping("/{data}")
    public ResponseEntity<Void> apagaAvaliacaoMesmaData(@PathVariable LocalDate data)
    {
        try {
            deletarAvaliacaoMesmaDataService.deletaAvaliacaoMesmaData(data);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

}
