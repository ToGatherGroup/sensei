package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas")
public class BuscarAvaliacoesIncompletasController {

    private final AvaliacaoService avaliacaoService;
    @GetMapping()
    public ResponseEntity<List<AvaliacaoIncompletaDTO>> buscaAvaliacoesIncompletas()
    {
        List<AvaliacaoIncompletaDTO> avaliacoesIncompletas =  avaliacaoService.buscaAvaliacoesIncompletas();
        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
