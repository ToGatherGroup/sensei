package com.togather.sensei.controllers.historiolesoesController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.services.AtletaGetService;
import com.togather.sensei.services.HistoricoLesoesGetService;
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
@RequestMapping("/historicolesoes")
public class HistoricoLesoesGetController {

    private final HistoricoLesoesGetService historicoLesoesGetService;

    @GetMapping
    public ResponseEntity<List<HistoricoLesoesModel>> findAllHistorico() {
        try {
            List<HistoricoLesoesModel> historicoLesoesModelList = historicoLesoesGetService.buscaHistoricoLesoes();
            return ResponseEntity.ok(historicoLesoesModelList);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
