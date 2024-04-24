package com.togather.sensei.controllers.avaliacaoposturalController;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacoesPosturaisByDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaopostural")
public class BuscaAvaliacoesPosturaisByDataController {

    private final AvaliacoesPosturaisByDataService avaliacoesPosturaisByDataService;

    @GetMapping("{atletaId}/{data}")
    public ResponseEntity<List<AvaliacaoPosturalDTO>> buscarAvaliacoesPosturaisByData(@PathVariable Long atletaId, @PathVariable LocalDate data){
        List<AvaliacaoPosturalModel> lst = avaliacoesPosturaisByDataService.buscarAvaliacoesPosturalByData(atletaId, data);
        List<AvaliacaoPosturalDTO> lstdto = new ArrayList<>();

        for(AvaliacaoPosturalModel item : lst) {
            AvaliacaoPosturalDTO temp = new AvaliacaoPosturalDTO();
            temp.setFoto(item.getFoto());
            temp.setPosicao(item.getAvaliacaoPosturalPK().getPosicao());
            lstdto.add(temp);
        }
        return ResponseEntity.ok().body(lstdto);
    }
}
