package sensei.services;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AtualizaAvaliacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizaAvaliacaoServiceImplTest {
    @Mock
    private AtletaRepository atletaRepository;
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private AtualizaAvaliacaoServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateAvaliacao_DeveAtualizarQuandoExiste() {
        AvaliacaoModelId id = mock(AvaliacaoModelId.class);
        AvaliacaoModel input = new AvaliacaoModel();
        input.setAvaliacaoModelId(id);
        AvaliacaoModel existente = new AvaliacaoModel();
        when(avaliacaoRepository.findById(id)).thenReturn(Optional.of(existente));
        AvaliacaoModel mapped = new AvaliacaoModel();
        when(modelMapper.map(input, AvaliacaoModel.class)).thenReturn(mapped);

        service.updateAvaliacao(input);
        verify(avaliacaoRepository).save(mapped);
    }

    @Test
    void updateAvaliacao_DeveLancarExcecaoQuandoNaoExiste() {
        AvaliacaoModelId id = mock(AvaliacaoModelId.class);
        AvaliacaoModel input = new AvaliacaoModel();
        input.setAvaliacaoModelId(id);
        when(avaliacaoRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.updateAvaliacao(input));
    }
}

