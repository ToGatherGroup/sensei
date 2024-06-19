package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RegistraExercicioColetivoService {
    void atualizarExercicioColetivo(List<ExercicioColetivoDTO> listaExercicioColetivo) throws InvocationTargetException, IllegalAccessException;
}
