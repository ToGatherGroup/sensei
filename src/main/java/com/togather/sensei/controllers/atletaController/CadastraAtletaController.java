package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;
import com.togather.sensei.services.atletaService.AtletaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class CadastraAtletaController {

    private final AtletaPostService atletaPostService;

    @PostMapping
    public ResponseEntity<AtletaModel> cadastraAtleta(@RequestBody AtletaDTO atletaDTO){
        try {
            AtletaModel atletaModel = atletaPostService.saveAtleta(atletaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(atletaModel);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PostMapping("/new")
    public ResponseEntity<AtletaNewModel> cadastraAtletaNew(@RequestBody AtletaDTO atletaDTO){
        try {
            AtletaNewModel atletaNewModel = atletaPostService.saveAtletaNew(atletaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(atletaNewModel);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}