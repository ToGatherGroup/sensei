package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaByNomePaginadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@CrossOrigin("*")
@RequestMapping("/atleta/nome")
@RequiredArgsConstructor
@RestController
public class BuscaAtletaNomePaginadaController {

    private final BuscaAtletaByNomePaginadaService buscaService;

    @GetMapping("/{nome}")
    public ResponseEntity<Page<AtletaIdNomeFotoDTO>> buscaAtletaNome(@PathVariable String nome, @PageableDefault( size = 16, sort = "nome") Pageable pageable){
        try {
            Page<AtletaIdNomeFotoDTO> atletaPage= buscaService.buscaNome(nome, pageable);
            return ResponseEntity.ok(atletaPage);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
