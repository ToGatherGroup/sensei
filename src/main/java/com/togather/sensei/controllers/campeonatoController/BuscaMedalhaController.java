package com.togather.sensei.controllers.campeonatoController;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonato")
@Tag(name = "Campeonato", description = "Endpoints para gerenciamento de campeonatos")
public class BuscaMedalhaController {

    private final BuscaMedalhaService buscaMedalhaService;


    @GetMapping("/{atletaId}")
    public ResponseEntity<List<MedalhaDTO>> cadastraCampeonato(@PathVariable Long atletaId) {
        try {
            List<MedalhaDTO> medalhas = buscaMedalhaService.buscaMedalhas(atletaId);
            return ResponseEntity.ok(medalhas);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
