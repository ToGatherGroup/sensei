package sensei.services;

import com.togather.sensei.dtos.avaliacao.ExercicioColetivoDTO;
import com.togather.sensei.dtos.avaliacao.PossuiAvaliacaoIncompletaDTO;
import com.togather.sensei.helper.NullBeanUtils;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.RegistraExercicioColetivoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistraExercicioColetivoServiceImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @Mock
    private AtletaRepository atletaRepository;
    @Mock
    private NullBeanUtils nullBeanUtils;
    @InjectMocks
    private RegistraExercicioColetivoServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atualizarExercicioColetivo_DeveRetornarCompletaQuandoNaoHaData() throws InvocationTargetException, IllegalAccessException {
        when(avaliacaoRepository.getDataAvaliacoesIncompletas()).thenReturn(null);
        PossuiAvaliacaoIncompletaDTO dto = service.atualizarExercicioColetivo(Collections.emptyList());
        assertTrue(dto.getAvaliacaoEstaCompleta());
    }

    @Test
    void atualizarExercicioColetivo_DeveAtualizarQuandoHaData() throws InvocationTargetException, IllegalAccessException {
        LocalDate data = LocalDate.now();
        when(avaliacaoRepository.getDataAvaliacoesIncompletas()).thenReturn(data).thenReturn(null);
        ExercicioColetivoDTO exercicio = new ExercicioColetivoDTO();
        exercicio.setAtletaId(1L);
        List<ExercicioColetivoDTO> lista = List.of(exercicio);
        AtletaModel atleta = new AtletaModel();
        atleta.setId(1L);
        when(atletaRepository.findAllById(anyList())).thenReturn(List.of(atleta));
        AvaliacaoModel avaliacao = mock(AvaliacaoModel.class);
        when(avaliacaoRepository.findAllByDataAndAtletaIdIn(eq(data), anyList())).thenReturn(List.of(avaliacao));
        when(avaliacao.getAvaliacaoModelId()).thenReturn(mock(com.togather.sensei.models.AvaliacaoModelId.class));
        when(avaliacao.getAvaliacaoModelId().getAtletaModel()).thenReturn(atleta);
        doNothing().when(nullBeanUtils).copyProperties(any(), any());
        when(avaliacaoRepository.saveAll(anyList())).thenReturn(null);
        PossuiAvaliacaoIncompletaDTO dto = service.atualizarExercicioColetivo(lista);
        assertTrue(dto.getAvaliacaoEstaCompleta());
    }
}

