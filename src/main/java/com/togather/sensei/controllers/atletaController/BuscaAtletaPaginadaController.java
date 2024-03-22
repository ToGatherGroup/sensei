package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class BuscaAtletaPaginadaController {

    private final BuscaAtletaPaginadaService buscaAtletaPaginadaService;
    @GetMapping
    public ResponseEntity<Page<AtletaModel>> findAllAtleta(@PageableDefault(sort = "nome", size = 5)Pageable pageable) {
        try {
            Page<AtletaModel> atletaModelList = buscaAtletaPaginadaService.buscaAtletas(pageable);
            return ResponseEntity.ok(atletaModelList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
