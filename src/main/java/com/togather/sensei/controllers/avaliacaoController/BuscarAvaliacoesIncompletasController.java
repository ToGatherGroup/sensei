package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas")
public class BuscarAvaliacoesIncompletasController {

    private final AvaliacaoIncompletaService avaliacaoIncompletaService;
    @GetMapping("/{exercicio}")
    public ResponseEntity<List<AtletaIdNomeDTO>> buscaAvaliacoesIncompletas(@PathVariable String exercicio)
    {
        List<AtletaIdNomeDTO> avaliacoesIncompletas =  avaliacaoIncompletaService.buscaAvaliacoesIncompletas(exercicio);
        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
