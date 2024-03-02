package com.togather.sensei.controllers.presencaController;

import com.togather.sensei.DTO.PresencaAtletaDTO;
import com.togather.sensei.services.PresencasDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta/presenca")
public class PresencasDeAtletaController {

    private final PresencasDeAtletaService presencasDeAtletaService;

    @GetMapping("/{id_atleta}")
    public ResponseEntity<PresencaAtletaDTO> presencasDeAtleta(@PathVariable("id_atleta") Long idAtleta){
        try {
            PresencaAtletaDTO presencas = presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta);
            return ResponseEntity.status(HttpStatus.OK).body(presencas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
