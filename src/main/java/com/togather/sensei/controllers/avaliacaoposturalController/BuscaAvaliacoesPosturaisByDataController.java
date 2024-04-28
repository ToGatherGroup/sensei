package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacoesPosturaisByDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class BuscaAvaliacoesPosturaisByDataController {

    private final AvaliacoesPosturaisByDataService avaliacoesPosturaisByDataService;

    @GetMapping("{atletaId}/{data}")
    public ResponseEntity<List<AvaliacaoPosturalDTO>> buscarAvaliacoesPosturaisByData(@PathVariable Long atletaId, @PathVariable LocalDate data) {
        return ResponseEntity.ok().body(avaliacoesPosturaisByDataService.buscarAvaliacoesPosturalByData(atletaId, data));
    }
}
