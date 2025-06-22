package sensei.services;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.DeletarAvaliacaoMesmaDataImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeletarAvaliacaoMesmaDataImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @InjectMocks
    private DeletarAvaliacaoMesmaDataImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deletaAvaliacaoMesmaData_DeveDeletarQuandoExiste() {
        LocalDate data = LocalDate.now();
        List<AvaliacaoModel> lista = new ArrayList<>();
        lista.add(new AvaliacaoModel());
        when(avaliacaoRepository.buscaAvaliacaoMesmaData(data)).thenReturn(lista);
        service.deletaAvaliacaoMesmaData(data);
        verify(avaliacaoRepository).deleteAll(lista);
    }

    @Test
    void deletaAvaliacaoMesmaData_DeveLancarExcecaoQuandoNaoExiste() {
        LocalDate data = LocalDate.now();
        when(avaliacaoRepository.buscaAvaliacaoMesmaData(data)).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, () -> service.deletaAvaliacaoMesmaData(data));
    }
}

