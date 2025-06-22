package sensei.services;

import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.DatasdeAvaliacaoPorAtletaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DatasdeAvaliacaoPorAtletaServiceImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @InjectMocks
    private DatasdeAvaliacaoPorAtletaServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarDatasAvaliacoesPorAtleta_DeveRetornarListaDeDatas() {
        List<Date> datas = Arrays.asList(new Date(), new Date());
        when(avaliacaoRepository.buscaAvaliacaoPorDataPorAtleta(1L)).thenReturn(datas);
        List<Date> resultado = service.buscarDatasAvaliacoesPorAtleta(1L);
        assertEquals(2, resultado.size());
        verify(avaliacaoRepository).buscaAvaliacaoPorDataPorAtleta(1L);
    }
}

