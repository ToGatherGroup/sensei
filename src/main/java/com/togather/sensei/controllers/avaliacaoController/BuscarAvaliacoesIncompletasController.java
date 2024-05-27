package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas")
public class BuscarAvaliacoesIncompletasController {

    private final AvaliacaoIncompletaService avaliacaoIncompletaService;
    @GetMapping()
    public ResponseEntity<ResponseAvaliacoesIncompletasDTO> buscaAvaliacoesIncompletas()
    {
        ResponseAvaliacoesIncompletasDTO avaliacoesIncompletas =  avaliacaoIncompletaService.buscaAvaliacoesIncompletas();
        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
