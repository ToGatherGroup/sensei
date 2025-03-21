package com.togather.sensei.controllers.dadosqualitativosController;

import com.togather.sensei.dtos.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.services.dadosqualitativosService.BuscarDadosQualitativosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/dados_qualitativos")
@Tag(name = "Relatório", description = "Endpoints para gerenciamento de relatórios")
public class BuscaDadosQualitativosController {

    private final BuscarDadosQualitativosService buscarDadosQualitativosService;

    @GetMapping("/{atleta_id}")
    public ResponseEntity<DadosQualitativosResponseDTO> buscaDadosQualitativosPorAtleta(@PathVariable Long atleta_id) {
        try {
            DadosQualitativosResponseDTO dadosQualitativosResponseDTO = buscarDadosQualitativosService.buscaDadosQualitativos(atleta_id);
            return ResponseEntity.ok(dadosQualitativosResponseDTO);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

}
