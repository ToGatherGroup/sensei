package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;

import java.lang.reflect.InvocationTargetException;

public interface ExercicioColetivoService {

    void atualizarExercicioColetivo(ExercicioColetivoDTO exercicioColetivo) throws InvocationTargetException, IllegalAccessException;

}
