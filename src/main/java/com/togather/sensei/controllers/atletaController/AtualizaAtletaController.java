package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AtletaNewModel;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atletas")
@Tag(name = "Atleta", description = "Endpoints para gerenciamento de atletas")
public class AtualizaAtletaController {

    private final AtualizaAtletatService atualizaAtletatService;

    @PutMapping
    public ResponseEntity<AtletaModel> alteraAtleta(@RequestBody AtletaModel atletaModel){
        try {
            AtletaModel atleta = atualizaAtletatService.updateAtleta(atletaModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PutMapping(("/new"))
    public ResponseEntity<AtletaNewModel> alteraAtletaNew(@RequestBody AtletaDTO atletaDTO){
        try {
            AtletaNewModel atleta = atualizaAtletatService.updateAtletaNew(atletaDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}

