package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.DTO.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.BuscaAtletaByNomePaginadaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/atleta/nome")
@RequiredArgsConstructor
@RestController
public class BuscaAtletaNomePaginadaController {

    private final BuscaAtletaByNomePaginadaService buscaService;

    @GetMapping("/{nome}")
    public ResponseEntity<Page<AtletaModel>> buscaAtletaNome(@PathVariable String nome, @PageableDefault( size = 16, page = 0,sort = "nome") Pageable pageable){

        Page<AtletaModel> atletaPage= buscaService.buscaNome(nome, pageable);
        return ResponseEntity.ok(atletaPage);
    }
}
