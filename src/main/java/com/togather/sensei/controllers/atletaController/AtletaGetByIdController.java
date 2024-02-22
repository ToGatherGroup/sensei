package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.AtletaDTO;
import com.togather.sensei.services.AtletaGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class AtletaGetByIdController {

    private final AtletaGetByIdService atletaGetByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<AtletaDTO> buscaAtletabyId(@PathVariable Long id){
        try {
            AtletaDTO atleta = atletaGetByIdService.findAtletaById(id);
            return ResponseEntity.ok(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
