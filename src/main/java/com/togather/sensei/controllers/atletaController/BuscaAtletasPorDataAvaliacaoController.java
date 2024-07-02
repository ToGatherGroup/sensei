package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaPorDataAvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta/avaliacao")
public class BuscaAtletasPorDataAvaliacaoController {

    private final BuscaAtletaPorDataAvaliacaoService buscaAtletaPorDataAvaliacaoService;

    @GetMapping("/{dataAvaliacao}")
    ResponseEntity<List<AtletaIdNomeDTO>> buscaAtletasbyData(@PathVariable LocalDate dataAvaliacao){
        try {
            List<AtletaIdNomeDTO> atletas = buscaAtletaPorDataAvaliacaoService.findAtletasbyData(dataAvaliacao);
            return ResponseEntity.ok(atletas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
