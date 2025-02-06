package com.togather.sensei.controllers.grupoController;

import com.togather.sensei.services.grupoService.EditaGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class EditaStatusGrupoController {

    private final EditaGrupoService editaGrupoService;

    @PutMapping("/atualizar/{id}/status/{status}")
    public ResponseEntity<String> updateStatusGrupo(@PathVariable Long id, @PathVariable Boolean status) {
        try {
            editaGrupoService.updateStatusGrupo(id,status);
            return ResponseEntity.ok("Status do grupo atualizado com sucesso");
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
