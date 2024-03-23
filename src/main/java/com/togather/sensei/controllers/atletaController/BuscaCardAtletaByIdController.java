package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import com.togather.sensei.services.atletaService.BuscaCardAtletaByIdService;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaCardByIdServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta_card")
public class BuscaCardAtletaByIdController {

    private final BuscaCardAtletaByIdService buscaAtletaByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<AtletaCardDTO> buscaAtletabyId(@PathVariable Long id){
        try {
            AtletaCardDTO atleta = buscaAtletaByIdService.findAtletaCardById(id);
            return ResponseEntity.ok(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
