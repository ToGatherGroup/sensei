package sensei.services;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.impl.BuscarTodosOsGruposServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarTodosOsGruposServiceImplTest {

    @Mock
    private GrupoRepository grupoRepository;

    @InjectMocks
    private BuscarTodosOsGruposServiceImpl buscarTodosOsGruposService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarTodosOsGrupos() {
        GrupoModel grupo1 = new GrupoModel();
        GrupoModel grupo2 = new GrupoModel();
        List<GrupoModel> grupos = Arrays.asList(grupo1, grupo2);
        when(grupoRepository.findAll()).thenReturn(grupos);

        List<GrupoModel> resultado = buscarTodosOsGruposService.getAllGrupos();
        assertEquals(2, resultado.size());
        verify(grupoRepository).findAll();
    }
}

