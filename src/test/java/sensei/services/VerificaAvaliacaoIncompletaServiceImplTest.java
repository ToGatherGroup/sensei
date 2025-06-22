package sensei.services;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.VerificaAvaliacaoIncompletaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VerificaAvaliacaoIncompletaServiceImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @InjectMocks
    private VerificaAvaliacaoIncompletaServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void verificarAvaliacoesIncompletas_DeveRetornarTrueQuandoExistem() {
        when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(Collections.singletonList(new AvaliacaoModel()));
        assertTrue(service.verificarAvaliacoesIncompletas());
    }

    @Test
    void verificarAvaliacoesIncompletas_DeveRetornarFalseQuandoNaoExistem() {
        when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(Collections.emptyList());
        assertFalse(service.verificarAvaliacoesIncompletas());
    }
}

