package com.togather.sensei.controllers.grupoController;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.CadastraGrupoSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class CadastraGrupoController {

    private final CadastraGrupoSerivce cadastraGrupoSerivce;

    @PostMapping
    public ResponseEntity<GrupoModel> cadastrarGrupo(@RequestBody String nomeGrupo) {
        try {
            GrupoModel grupoModel = cadastraGrupoSerivce.cadastrarGrupo(nomeGrupo);
            return ResponseEntity.status(HttpStatus.CREATED).body(grupoModel);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
