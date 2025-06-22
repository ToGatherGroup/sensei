package sensei.services;

import com.togather.sensei.dtos.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.dadosqualitativosService.impl.BuscarDadosQualitativosImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarDadosQualitativosImplTest {
    @Mock
    private AtletaRepository atletaRepository;
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @InjectMocks
    private BuscarDadosQualitativosImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscaDadosQualitativos_DeveRetornarDadosQuandoAtletaExiste() {
        long atletaId = 1L;
        AtletaModel atleta = new AtletaModel();
        atleta.setNascimento(LocalDate.of(2000, 1, 1));
        when(atletaRepository.findById(atletaId)).thenReturn(Optional.of(atleta));
        when(avaliacaoRepository.resultadoClassifcacaoCooperPorAtleta(atletaId)).thenReturn("Bom");
        when(avaliacaoRepository.resultadoClassificacaoFlexoesPorAtleta(atletaId)).thenReturn("Ótimo");
        when(avaliacaoRepository.resultadoClassificacaoVO2PorAtleta(atletaId)).thenReturn("Excelente");
        when(avaliacaoRepository.resultadoClassificacaoAbdominaisPorAtleta(atletaId)).thenReturn("Regular");
        when(avaliacaoRepository.resultadoClassificacaoIMCAdolescentePorAtleta(atletaId)).thenReturn("Normal");

        DadosQualitativosResponseDTO resp = service.buscaDadosQualitativos(atletaId);
        assertNotNull(resp);
        assertNotNull(resp.getDados());
        assertFalse(resp.getDados().isEmpty());
        assertEquals(5, resp.getDados().size());
    }

    @Test
    void buscaDadosQualitativos_DeveLancarExcecaoQuandoAtletaNaoExiste() {
        long atletaId = 2L;
        when(atletaRepository.findById(atletaId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.buscaDadosQualitativos(atletaId));
    }
}

