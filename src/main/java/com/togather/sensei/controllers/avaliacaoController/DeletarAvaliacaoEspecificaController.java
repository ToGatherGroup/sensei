//package com.togather.sensei.controllers.avaliacaoController;
//
//import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoEspecificaService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.HttpClientErrorException;
//
//import java.time.LocalDate;
//
//@RestController
//@CrossOrigin("*")
//@RequiredArgsConstructor
//@RequestMapping("/avaliacao_especifica")
//public class DeletarAvaliacaoEspecificaController {
//
//    private final DeletarAvaliacaoEspecificaService deletarAvaliacaoEspecificaService;
//
//    @DeleteMapping("/{data}/{atletaId}")
//    public ResponseEntity<Void> apagaAvaliacaoMesmaData(@PathVariable LocalDate data, @PathVariable Long atletaId)
//    {
//        try {
//            deletarAvaliacaoEspecificaService.deletarAvaliacaoEspecifica(data, atletaId);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (HttpClientErrorException e) {
//            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
//        }
//    }
//}
