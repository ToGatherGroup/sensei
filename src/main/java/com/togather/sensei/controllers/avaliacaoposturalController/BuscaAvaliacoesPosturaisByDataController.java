package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.dtos.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacoesPosturaisByDataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacoes")
@Tag(name = "Avaliação", description = "Endpoints para gerenciamento de avaliações")
public class BuscaAvaliacoesPosturaisByDataController {

    private final AvaliacoesPosturaisByDataService avaliacoesPosturaisByDataService;

    @GetMapping("/posturais/{atletaId}/data/{data}")
    public ResponseEntity<List<AvaliacaoPosturalDTO>> buscarAvaliacoesPosturaisByData(@PathVariable Long atletaId, @PathVariable LocalDate data) {
        try {
            List<AvaliacaoPosturalDTO> avaliacaoPosturalDTOS = avaliacoesPosturaisByDataService.buscarAvaliacoesPosturalByData(atletaId, data);
            return ResponseEntity.ok().body(avaliacaoPosturalDTOS);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
