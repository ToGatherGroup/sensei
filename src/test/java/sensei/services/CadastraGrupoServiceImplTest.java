package sensei.services;

import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.grupoService.impl.CadastraGrupoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CadastraGrupoServiceImplTest {

    @Mock
    private GrupoRepository grupoRepository;

    @InjectMocks
    private CadastraGrupoServiceImpl cadastraGrupoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarGrupoQuandoNaoExiste() {
        String nomeGrupo = "Grupo Teste";
        when(grupoRepository.findByNome(nomeGrupo)).thenReturn(null);
        GrupoModel grupoSalvo = new GrupoModel();
        grupoSalvo.setNome(nomeGrupo);
        when(grupoRepository.save(any(GrupoModel.class))).thenReturn(grupoSalvo);

        GrupoModel resultado = cadastraGrupoService.cadastrarGrupo(nomeGrupo);
        assertNotNull(resultado);
        assertEquals(nomeGrupo, resultado.getNome());
        verify(grupoRepository).save(any(GrupoModel.class));
    }

    @Test
    void deveLancarExcecaoQuandoGrupoJaExiste() {
        String nomeGrupo = "Grupo Existente";
        GrupoModel grupoExistente = new GrupoModel();
        grupoExistente.setNome(nomeGrupo);
        when(grupoRepository.findByNome(nomeGrupo)).thenReturn(grupoExistente);

        assertThrows(IllegalArgumentException.class, () -> {
            cadastraGrupoService.cadastrarGrupo(nomeGrupo);
        });
    }
}

