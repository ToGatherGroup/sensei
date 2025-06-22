package sensei.services;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.impl.EditaGrupoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EditaGrupoServiceImplTest {

    @Mock
    private GrupoRepository grupoRepository;

    @InjectMocks
    private EditaGrupoServiceImpl editaGrupoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveAtualizarGrupoQuandoExiste() {
        GrupoModel grupo = new GrupoModel();
        grupo.setId(1L);
        when(grupoRepository.findById(1L)).thenReturn(Optional.of(grupo));
        when(grupoRepository.save(grupo)).thenReturn(grupo);

        GrupoModel resultado = editaGrupoService.updateGrupo(grupo);
        assertNotNull(resultado);
        verify(grupoRepository).save(grupo);
    }

    @Test
    void deveLancarExcecaoQuandoGrupoNaoExisteParaUpdate() {
        GrupoModel grupo = new GrupoModel();
        grupo.setId(2L);
        when(grupoRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> editaGrupoService.updateGrupo(grupo));
    }

    @Test
    void deveAtualizarStatusGrupoQuandoExiste() {
        GrupoModel grupo = new GrupoModel();
        grupo.setId(3L);
        grupo.setIsAtivo(false);
        when(grupoRepository.findById(3L)).thenReturn(Optional.of(grupo));
        when(grupoRepository.save(grupo)).thenReturn(grupo);

        editaGrupoService.updateStatusGrupo(3L, true);
        assertTrue(grupo.getIsAtivo());
        verify(grupoRepository).save(grupo);
    }

    @Test
    void deveLancarExcecaoQuandoGrupoNaoExisteParaUpdateStatus() {
        when(grupoRepository.findById(4L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> editaGrupoService.updateStatusGrupo(4L, true));
    }
}

