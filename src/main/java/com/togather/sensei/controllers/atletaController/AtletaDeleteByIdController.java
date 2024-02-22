package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.services.AtletaDeleteByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class AtletaDeleteByIdController
{
    private final AtletaDeleteByIdService atletaDeleteByIdService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaAtletaById(@PathVariable Long id)
    {
        try {
            atletaDeleteByIdService.deleteAtletaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}