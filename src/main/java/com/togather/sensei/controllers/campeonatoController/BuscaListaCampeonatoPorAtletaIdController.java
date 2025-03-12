package com.togather.sensei.controllers.campeonatoController;

import com.togather.sensei.dtos.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.services.campeonatosService.impl.BuscaListaCampeonatoPorAtletaIdServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonatos")
public class BuscaListaCampeonatoPorAtletaIdController {

    private final BuscaListaCampeonatoPorAtletaIdServiceImpl listaCampeonatoPorAtletaIdService;

    @GetMapping("/{atleta_id}/lista")
    public ResponseEntity<List<ListaCampeonatoDTO>> listaCampeonatos(@PathVariable Long atleta_id) {
        try {
            List<ListaCampeonatoDTO> campeonatos = listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(atleta_id);
            return ResponseEntity.ok(campeonatos);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
