package com.togather.sensei.controllers.grupoController;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.EditaGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class EditaGrupoController {

    private final EditaGrupoService editaGrupoService;

    @PutMapping
    public ResponseEntity<GrupoModel> updateGrupo(@RequestBody GrupoModel grupoModel) {
        try {
            GrupoModel historico = editaGrupoService.updateGrupo(grupoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(historico);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
