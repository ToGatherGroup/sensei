package com.togather.sensei.controllers.campeonatoController;

import com.togather.sensei.dtos.campeonato.MedalhaDTO;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonatos")
public class BuscaMedalhaController {

    private final BuscaMedalhaService buscaMedalhaService;


    @GetMapping("/{atletaId}/medalhas")
    public ResponseEntity<List<MedalhaDTO>> listarMedalhas(@PathVariable Long atletaId) {
        try {
            List<MedalhaDTO> medalhas = buscaMedalhaService.buscaMedalhas(atletaId);
            return ResponseEntity.ok(medalhas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
