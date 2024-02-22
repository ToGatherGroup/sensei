package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.AtletaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class AtletaPostController {

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
}