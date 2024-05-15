package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import com.togather.sensei.services.atletaService.BuscaAtletaByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/atleta")
@RequiredArgsConstructor
public class AtualizaStatusAtletaController {

    private final AtualizaAtletatService atualizaAtletatService;

    @PutMapping("/atualizar/{id}/status/{status}")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @PathVariable Boolean status) {

        atualizaAtletatService.updateStatusAtleta(id,status);

        return ResponseEntity.ok("Status do atleta atualizado com sucesso");

    }

}
