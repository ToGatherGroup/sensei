package com.togather.sensei.controllers.presencaController;

import com.togather.sensei.services.ChamadaDeAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta/chamada")
public class ChamadaDeAtletaController {

    private final ChamadaDeAtletaService chamadaDeAtletaService;
    @PostMapping()
    public ResponseEntity<Void> chamadaDeAtleta(@RequestBody List<Long> idAtletaList){
        try {
            chamadaDeAtletaService.chamadaDeAtleta(idAtletaList);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
