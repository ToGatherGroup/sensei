package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.services.avaliacaoService.AvaliacaoColetivaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/avaliacaocoletiva")
public class CadastrarAvaliacaoColetivaController {

    private final AvaliacaoColetivaService avaliacaoColetivaService;

    @PostMapping
    public ResponseEntity<ResponseAvaliacoesIncompletasDTO> cadastrarAvaliacaoColetiva(){
        try {
           ResponseAvaliacoesIncompletasDTO response=  avaliacaoColetivaService.cadastrarAvaliacaoColetiva();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
