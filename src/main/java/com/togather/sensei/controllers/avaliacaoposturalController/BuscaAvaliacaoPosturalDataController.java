package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalGetDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class BuscaAvaliacaoPosturalDataController {

    private final AvaliacaoPosturalGetDataService avaliacaoPosturalGetDataService;

    @GetMapping("/datas/{atletaId}")
    public ResponseEntity<List<LocalDate>> buscaAvaliacaoDataId(@PathVariable Long atletaId){
        return ResponseEntity.ok().body(avaliacaoPosturalGetDataService.buscarDatasDeAvaliacoesPorAtletaId(atletaId));
    }
}
