package sensei.services;

import com.togather.sensei.dtos.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.dtos.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacaoColetivaImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvaliacaoColetivaImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @Mock
    private AtletaRepository atletaRepository;
    @Mock
    private ModelMapper mapper;
    @InjectMocks
    private AvaliacaoColetivaImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void cadastrarAvaliacaoColetiva_DeveCadastrarComSucesso() {
        when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(Collections.emptyList());
        List<AtletaModel> atletas = new ArrayList<>();
        AtletaModel atleta = new AtletaModel();
        atleta.setId(1L);
        atleta.setNome("Teste");
        atletas.add(atleta);
        when(atletaRepository.buscaListaAtletaIdAtivo()).thenReturn(atletas);
        when(avaliacaoRepository.buscaAvaliacaoMesmaData(any())).thenReturn(new ArrayList<>());
        when(mapper.map(any(AvaliacaoModel.class), eq(ListaExerciciosDTO.class))).thenReturn(new ListaExerciciosDTO());

        ResponseAvaliacoesIncompletasDTO result = service.cadastrarAvaliacaoColetiva();
        assertNotNull(result);
        verify(avaliacaoRepository).save(any(AvaliacaoModel.class));
    }

    @Test
    void cadastrarAvaliacaoColetiva_DeveLancarBusinessExceptionSeExistemIncompletas() {
        when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(List.of(new AvaliacaoModel()));
        assertThrows(BusinessException.class, () -> service.cadastrarAvaliacaoColetiva());
    }
}

