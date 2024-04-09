package com.togather.sensei.controllers.presencaController;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;
import com.togather.sensei.services.presencaService.PresencasDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta/presenca")
public class PresencasDeAtletaController {

    private final PresencasDeAtletaService presencasDeAtletaService;

    @GetMapping("/{id_atleta}/data_inicio/{inicio}/data_fim/{fim}")
    public ResponseEntity<PresencaAtletaDTO> presencasDeAtleta(
            @PathVariable("id_atleta") Long idAtleta,
            @PathVariable("inicio") LocalDate dataInicio,
            @PathVariable("fim") LocalDate dataFim){
        try {
            PresencaAtletaDTO presencas = presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta, dataInicio, dataFim);
            return ResponseEntity.status(HttpStatus.OK).body(presencas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
