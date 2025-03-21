package com.togather.sensei.controllers.lesaoController;

import com.togather.sensei.dtos.lesao.LesaoDTO;
import com.togather.sensei.services.lesaoService.BuscarHistoricoLesoesPorAtletaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/lesoes")
@Tag(name = "Lesão", description = "Endpoint para gerenciamento de lesões")
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
