package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.DTO.avaliacao.PossuiAvaliacaoIncompletaDTO;
import com.togather.sensei.services.avaliacaoService.RegistraExercicioColetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/exercicio_coletivo")
public class EnviarExercicioColetivoController {

    private final RegistraExercicioColetivoService registraExercicioColetivoService;

    @PatchMapping()
    public ResponseEntity<PossuiAvaliacaoIncompletaDTO> atualizarExercicioColetivo(@RequestBody List<ExercicioColetivoDTO> listaExercicioColetivo) throws InvocationTargetException, IllegalAccessException {
        try {
            PossuiAvaliacaoIncompletaDTO result = registraExercicioColetivoService.atualizarExercicioColetivo(listaExercicioColetivo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
