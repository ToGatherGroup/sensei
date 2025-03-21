package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaPorDataAvaliacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atletas/avaliacao")
@Tag(name = "Atleta", description = "Endpoints para gerenciamento de atletas")
public class BuscaAtletasPorDataAvaliacaoController {

    private final BuscaAtletaPorDataAvaliacaoService buscaAtletaPorDataAvaliacaoService;

    @GetMapping("/{dataAvaliacao}")
    public ResponseEntity<List<AtletaIdNomeDTO>> buscaAtletasbyData(@PathVariable LocalDate dataAvaliacao){
        try {
            List<AtletaIdNomeDTO> atletas = buscaAtletaPorDataAvaliacaoService.findAllAtletasbyData(dataAvaliacao);
            return ResponseEntity.ok(atletas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
