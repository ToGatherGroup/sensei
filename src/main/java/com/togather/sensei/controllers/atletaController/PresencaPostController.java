package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.PresencaDTO;
import com.togather.sensei.models.PresencaModel;
import com.togather.sensei.services.PresencaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/presenca")

public class PresencaPostController {

    private final PresencaPostService presencaPostService;

    @PostMapping
    public ResponseEntity<PresencaModel> cadastrarPresenca(@RequestBody PresencaDTO presencaDTO) {
        try {
            PresencaModel presencaModel = presencaPostService.savePresenca(presencaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(presencaModel);

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}

