package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class CadastraAvaliacaoPosturalController {

    private final AvaliacaoPosturalPostService avaliacaoPosturalPostService;

    @PostMapping
    public ResponseEntity<AvaliacaoPosturalModel> cadastraAvaliacaoPostural(@RequestBody AvaliacaoPosturalModel avaliacaoPosturalModel) {
        try {
            AvaliacaoPosturalModel avaliacaoModel = avaliacaoPosturalPostService.saveAvaliacaoPostural(avaliacaoPosturalModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoModel);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
