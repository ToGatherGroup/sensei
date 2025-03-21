package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaCardDTO;
import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.services.atletaService.BuscaCardAtletaByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atletas")
@Tag(name = "Atleta", description = "Endpoints para gerenciamento de atletas")
public class BuscaCardAtletaByIdController {

    private final BuscaCardAtletaByIdService buscaAtletaByIdService;

    @GetMapping("/ficha/{id}")
    public ResponseEntity<AtletaCardDTO> buscaAtletabyId(@PathVariable Long id){
        try {
            AtletaCardDTO atleta = buscaAtletaByIdService.findAtletaCardById(id);
            return ResponseEntity.ok(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
