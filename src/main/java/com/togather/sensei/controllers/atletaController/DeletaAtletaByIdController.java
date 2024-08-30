//package com.togather.sensei.controllers.atletaController;
//
//import com.togather.sensei.services.atletaService.DeletaAtletaByIdService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.HttpClientErrorException;
//
//@RestController
//@CrossOrigin("*")
//@RequiredArgsConstructor
//@RequestMapping("/atleta")
//public class DeletaAtletaByIdController {
//    private final DeletaAtletaByIdService deletaAtletaByIdService;
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> apagaAtletaById(@PathVariable Long id) {
//        deletaAtletaByIdService.deleteAtletaById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}