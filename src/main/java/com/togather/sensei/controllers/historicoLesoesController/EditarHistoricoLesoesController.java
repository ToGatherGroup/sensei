package com.togather.sensei.controllers.historicoLesoesController;

import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.services.EditarHistoricoLesoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/historicolesoes")
public class EditarHistoricoLesoesController {
    private final EditarHistoricoLesoesService service;

    @PutMapping
    public ResponseEntity<HistoricoLesoesModel> atualizarHistoricoLesao(@RequestBody HistoricoLesoesModel model){
        try {
            HistoricoLesoesModel historico = service.updateHistoricoLesao(model);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(historico);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
