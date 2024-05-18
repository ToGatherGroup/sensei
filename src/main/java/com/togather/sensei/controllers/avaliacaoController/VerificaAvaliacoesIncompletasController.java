package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import com.togather.sensei.services.avaliacaoService.VerificaAvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas/verificar")
public class VerificaAvaliacoesIncompletasController {

    private final VerificaAvaliacaoIncompletaService verificaAvaliacaoIncompletasService;
    @GetMapping()
    public ResponseEntity<Boolean> verificaAvaliacoesIncompletas(){

        Boolean avaliacoesIncompletas =  verificaAvaliacaoIncompletasService.verificarAvaliacoesIncompletas();

        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
