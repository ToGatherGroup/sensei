package com.togather.sensei.controllers.avaliacaoController;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.services.avaliacaoService.ExercicioColetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/exercicio_coletivo")
public class EnviarExercicioColetivoController {

    private final ExercicioColetivoService exercicioColetivoService;

    @PatchMapping()

    public ResponseEntity<Void> atualizarExercicioColetivo(@RequestBody List<ExercicioColetivoDTO> listaexercicioColetivo) throws InvocationTargetException, IllegalAccessException {
            exercicioColetivoService.atualizarExercicioColetivo(listaexercicioColetivo);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
