package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaIdNomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta/lista")
public class BuscaAtletaIdNomeController {

    private final BuscaAtletaIdNomeService buscaAtletaIdNomeService;

    @GetMapping
    public ResponseEntity<List<AtletaIdNomeDTO>> buscaListadeChamada(){


        return ResponseEntity.ok().body(buscaAtletaIdNomeService.findAtletaIdNome());
    }
}
