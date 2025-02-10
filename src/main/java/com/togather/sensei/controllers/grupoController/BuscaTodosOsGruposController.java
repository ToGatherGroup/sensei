package com.togather.sensei.controllers.grupoController;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.BuscarTodosOsGruposService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class BuscaTodosOsGruposController {

    private final BuscarTodosOsGruposService buscarTodosOsGruposService;

    @GetMapping
    public ResponseEntity<List<GrupoModel>> getAllGrupos() {
        List<GrupoModel> grupos = buscarTodosOsGruposService.getAllGrupos();
        return ResponseEntity.ok(grupos);
    }
}
