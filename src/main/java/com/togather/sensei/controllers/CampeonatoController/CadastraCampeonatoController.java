package com.togather.sensei.controllers.CampeonatoController;

import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.services.campeonatosService.CadastraCampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonato")
public class CadastraCampeonatoController {

    private final CadastraCampeonatoService cadastraCampeonatoService;


    @PostMapping()
    public ResponseEntity<CampeonatosDisputadosModel> cadastraCampeonato(@RequestBody CampeonatosDisputadosModel mdoel){
        CampeonatosDisputadosModel campeonato = cadastraCampeonatoService.salvaCampeonato(mdoel);
        return ResponseEntity.ok(campeonato);
    }
}
