package com.togather.sensei.controllers.lesaoController;

import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.EditarLesaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/historicolesoes")
public class EditarLesaoController {
    private final EditarLesaoService service;

    @PutMapping
    public ResponseEntity<LesaoModel> atualizarHistoricoLesao(@RequestBody LesaoModel model){
        try {
            LesaoModel historico = service.updateHistoricoLesao(model);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(historico);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
