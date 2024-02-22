package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.AtletaPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class AtletaPutController {

    private final AtletaPutService atletaPutService;

    @PutMapping
    public ResponseEntity<AtletaModel> alteraAtleta(@RequestBody AtletaModel atletaModel){
        try {
            AtletaModel atleta = atletaPutService.updateAtleta(atletaModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
