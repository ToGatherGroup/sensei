package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class BuscaAtletaByIdController {

    private final BuscaAtletaByIdService buscaAtletaByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<AtletaModel> buscaAtletabyId(@PathVariable Long id){
        try {
            AtletaModel atleta = buscaAtletaByIdService.findAtletaById(id);
            return ResponseEntity.ok(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
