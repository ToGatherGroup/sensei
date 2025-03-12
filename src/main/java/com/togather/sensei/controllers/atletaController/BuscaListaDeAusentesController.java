package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaIdNomeDTO;
import com.togather.sensei.services.atletaService.BuscaListaDeAusentesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atletas")
public class BuscaListaDeAusentesController {
    private final BuscaListaDeAusentesService buscaListaDeAusentesService;

    @GetMapping("/lista_ausentes")
    public ResponseEntity<List<AtletaIdNomeDTO>> buscaListadeAusentes() {
        try {
            List<AtletaIdNomeDTO> ausentes = buscaListaDeAusentesService.getListaDeAusentes();
            return ResponseEntity.ok().body(ausentes);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
