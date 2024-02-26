package com.togather.sensei.controllers.historicoLesoesController;

import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.services.BuscarHistoricoLesoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/historicolesoes")
public class BuscarHistoricoLesoesPorAtletaController {

    private final BuscarHistoricoLesoesPorAtletaService buscarHistoricoLesoesPorAtletaService;

    @GetMapping("/{atleta_id}")
    public ResponseEntity<List<HistoricoLesoesModel>> historicoDeLesoesPorAtleta(@PathVariable long atleta_id) {
        try {
            List<HistoricoLesoesModel> lesoesAtleta = buscarHistoricoLesoesPorAtletaService.buscaHistoricoLesoes(atleta_id);
            return ResponseEntity.ok(lesoesAtleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
