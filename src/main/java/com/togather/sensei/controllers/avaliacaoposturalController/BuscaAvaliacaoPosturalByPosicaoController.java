package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalGetByIdPosicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class BuscaAvaliacaoPosturalByPosicaoController {

    private final AvaliacaoPosturalGetByIdPosicaoService avaliacaoPosturalGetByIdPosicaoService;

    @GetMapping("{atletaId}/{data}/{posicao}")
    public ResponseEntity<String> buscarAvaliacaoPosturalByPosicao(@PathVariable Long atletaId, @PathVariable LocalDate data, @PathVariable PosicaoFotoEnum posicao){
       String foto = avaliacaoPosturalGetByIdPosicaoService.buscarAvaliacaoPosturalByPosicao(atletaId, data, posicao);
        return ResponseEntity.ok().body(foto);
    }
}
