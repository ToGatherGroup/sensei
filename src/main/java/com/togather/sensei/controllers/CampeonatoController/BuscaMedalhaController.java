package com.togather.sensei.controllers.CampeonatoController;

import com.togather.sensei.DTO.MedalhaDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import com.togather.sensei.services.campeonatosService.CadastraCampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/campeonato")
public class BuscaMedalhaController {

    private final BuscaMedalhaService buscaMedalhaService;


    @GetMapping("/{atletaId}")
    public ResponseEntity<List<MedalhaDTO>> cadastraCampeonato(@PathVariable Long atletaId){
        List<MedalhaDTO> medalhas= buscaMedalhaService.buscaMedalhas(atletaId);
        return ResponseEntity.ok(medalhas);
    }
}
