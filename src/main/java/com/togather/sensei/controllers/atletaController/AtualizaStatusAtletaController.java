package com.togather.sensei.controllers.atletaController;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/atleta")
public class AtualizaStatusAtletaController {


        @Autowired
        private AtletaRepository atletaRepository;

        @PutMapping("/atualizar/{id}/status/{status}")
        public ResponseEntity<String> atualizarStatus(@PathVariable Long id, @PathVariable Boolean status) {
            AtletaModel atleta = atletaRepository.findById(id).orElse(null);

            if (atleta != null) {
                atleta.setIsAtivo(status);
                atletaRepository.save(atleta);
                return ResponseEntity.ok("Status do atleta atualizado com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atleta não encontrado");
            }
        }
    }

