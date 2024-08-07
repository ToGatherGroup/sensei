package com.togather.sensei.controllers.campeonatoController;

import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.services.campeonatosService.CadastraCampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonato")
public class CadastraCampeonatoController {

    private final CadastraCampeonatoService cadastraCampeonatoService;


    @PostMapping()
    public ResponseEntity<CampeonatosDisputadosModel> cadastraCampeonato(@RequestBody CampeonatosDisputadosModel model){
        try {
            CampeonatosDisputadosModel campeonato = cadastraCampeonatoService.salvaCampeonato(model);
            return ResponseEntity.ok(campeonato);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
