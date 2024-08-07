package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
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
@RequestMapping("/atleta/lista")
public class BuscaListaDeAusentesController {
    private final BuscaListaDeAusentesService buscaListaDeAusentesService;

    @GetMapping()
    public ResponseEntity<List<AtletaIdNomeDTO>> buscaListadeAusentes() {
        try {
            return ResponseEntity.ok().body(buscaListaDeAusentesService.getListaDeAusentes());
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
