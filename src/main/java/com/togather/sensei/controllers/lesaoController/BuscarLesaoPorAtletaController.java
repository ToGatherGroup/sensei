package com.togather.sensei.controllers.lesaoController;

import com.togather.sensei.DTO.lesao.LesaoDTO;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.BuscarHistoricoLesoesPorAtletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/lesao")
public class BuscarLesaoPorAtletaController {

    private final BuscarHistoricoLesoesPorAtletaService buscarHistoricoLesoesPorAtletaService;

    @GetMapping("/{atleta_id}")
    public ResponseEntity<List<LesaoDTO>> historicoDeLesoesPorAtleta(@PathVariable long atleta_id) {
        try {
            List<LesaoDTO> lesoesAtleta = buscarHistoricoLesoesPorAtletaService.buscaHistoricoLesoes(atleta_id);
            return ResponseEntity.ok(lesoesAtleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
