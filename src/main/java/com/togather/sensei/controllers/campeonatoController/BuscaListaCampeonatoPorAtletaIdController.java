package com.togather.sensei.controllers.campeonatoController;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.services.campeonatosService.BuscaListaCampeonatoPorAtletaIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonato/lista")
public class BuscaListaCampeonatoPorAtletaIdController {

    @Autowired
    private BuscaListaCampeonatoPorAtletaIdService listaCampeonatoPorAtletaIdService;

    @GetMapping("/{atleta_id}")
    public ResponseEntity<List<ListaCampeonatoDTO>> listaCampeonatos(@PathVariable Long atleta_id) {
        List<ListaCampeonatoDTO> campeonatos = listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(atleta_id);
        return ResponseEntity.ok(campeonatos);
    }
}
