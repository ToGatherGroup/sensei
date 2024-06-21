package com.togather.sensei.services.avaliacaoService;

import com.togather.sensei.DTO.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.DTO.avaliacao.PossuiAvaliacaoIncompletaDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RegistraExercicioColetivoService {
    PossuiAvaliacaoIncompletaDTO atualizarExercicioColetivo(List<ExercicioColetivoDTO> listaExercicioColetivo) throws InvocationTargetException, IllegalAccessException;
}
