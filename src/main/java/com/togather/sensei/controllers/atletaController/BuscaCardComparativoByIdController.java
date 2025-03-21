package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.dtos.atleta.AtletaCardComparativoDTO;
import com.togather.sensei.DTO.atleta.AtletaCardComparativoDTO;
import com.togather.sensei.services.atletaService.BuscaComparativoAtletaByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atletas")
@Tag(name = "Atleta", description = "Endpoints para gerenciamento de atletas")
public class BuscaCardComparativoByIdController {

    private final BuscaComparativoAtletaByIdService buscaComparativoByIdService;

    @GetMapping("/comparativo/{id}")
    public ResponseEntity<AtletaCardComparativoDTO> buscaComparativoById(@PathVariable Long id){
        try {
            AtletaCardComparativoDTO atleta = buscaComparativoByIdService.findAtletaCardById(id);
            return ResponseEntity.ok(atleta);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
