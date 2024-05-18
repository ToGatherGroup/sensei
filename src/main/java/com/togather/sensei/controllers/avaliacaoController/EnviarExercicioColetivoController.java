package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.services.avaliacaoService.ExercicioColetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/exercicio_coletivo")
public class EnviarExercicioColetivoController {

    private final ExercicioColetivoService exercicioColetivoService;

    @PatchMapping()

    public ResponseEntity<Void> atualizarExercicioColetivo(@RequestBody ExercicioColetivoDTO exercicioColetivo) throws InvocationTargetException, IllegalAccessException {
            exercicioColetivoService.atualizarExercicioColetivo(exercicioColetivo);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
