package com.togather.sensei.controllers.dadosqualitativosController;

import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.services.dadosqualitativosService.BuscarDadosQualitativosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/dados_qualitativos")
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
