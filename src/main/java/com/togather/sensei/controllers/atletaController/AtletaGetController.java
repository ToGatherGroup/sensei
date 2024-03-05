package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.AtletaGetService;
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
@RequestMapping("/atleta")
public class AtletaGetController {

    private final AtletaGetService atletaGetService;
    @GetMapping
    public ResponseEntity<List<AtletaModel>> findAllAtleta() {
        try {
            List<AtletaModel> atletaModelList = atletaGetService.buscaAtletas();
            return ResponseEntity.ok(atletaModelList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
