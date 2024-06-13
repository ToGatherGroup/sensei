package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class CadastraAvaliacaoPosturalController {

    private final AvaliacaoPosturalPostService avaliacaoPosturalPostService;

    @PostMapping
    public ResponseEntity<Void> cadastraAvaliacaoPostural(@RequestBody List<AvaliacaoPosturalModel> avaliacaoPosturalList) {
        try {
            avaliacaoPosturalPostService.saveAvaliacaoPostural(avaliacaoPosturalList);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
