package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.services.atletaService.AtualizaAtletatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequestMapping("/atleta")
@RequiredArgsConstructor
public class AtualizaStatusAtletaController {

    private final AtualizaAtletatService atualizaAtletatService;

    @PutMapping("/atualizar/{id}/status/{status}")
    public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @PathVariable Boolean status) {
        try {
            atualizaAtletatService.updateStatusAtleta(id,status);
            return ResponseEntity.ok("Status do atleta atualizado com sucesso");
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
