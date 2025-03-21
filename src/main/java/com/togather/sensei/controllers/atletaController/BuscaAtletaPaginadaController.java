package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/atletas")
@Tag(name = "Atleta", description = "Endpoints para gerenciamento de atletas")
public class BuscaAtletaPaginadaController {

    private final BuscaAtletaPaginadaService buscaAtletaPaginadaService;
    @GetMapping
    public ResponseEntity<Page<AtletaIdNomeFotoDTO>> findAllAtleta(@PageableDefault( size = 16, page = 0,sort = "nome") Pageable pageable) {
        try {
            Page<AtletaIdNomeFotoDTO> atletaModelList = buscaAtletaPaginadaService.buscaAtletas(pageable);
            return ResponseEntity.ok(atletaModelList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

//    @GetMapping("/new")
//    public ResponseEntity<Page<AtletaIdNomeFotoDTO>> findAllAtletaNew(Pageable pageable) {
//        try {
//            Page<AtletaIdNomeFotoDTO> atletaModelList = buscaAtletaPaginadaService.buscaAtletasFotosCache(pageable);
//            return ResponseEntity.ok(atletaModelList);
//        } catch (HttpClientErrorException e) {
//            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
//        }
//    }
}
