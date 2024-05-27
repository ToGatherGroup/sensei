package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.DTO.avaliacao.AvaliacaoDTO;
import com.togather.sensei.models.AvaliacaoModel;
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
    @GetMapping()
    public ResponseEntity<List<AvaliacaoDTO>> buscaAvaliacoesIncompletas()
    {
        List<AvaliacaoDTO> avaliacoesIncompletas =  avaliacaoIncompletaService.buscaAvaliacoesIncompletas();
        return ResponseEntity.ok().body(avaliacoesIncompletas);
    }
}
