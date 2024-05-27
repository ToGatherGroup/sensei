package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.DTO.avaliacao.ResponseIncommpletasDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes_incompletas")
public class BuscarAvaliacoesIncompletasController {

    private final AvaliacaoIncompletaService avaliacaoIncompletaService;
    @GetMapping()
    public ResponseEntity<ResponseIncommpletasDTO> buscaAvaliacoesIncompletas()
    {
        ResponseIncommpletasDTO avaliacoesIncompletas =  avaliacaoIncompletaService.buscaAvaliacoesIncompletas();
        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
