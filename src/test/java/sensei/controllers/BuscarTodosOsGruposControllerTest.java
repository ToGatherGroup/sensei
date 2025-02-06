package sensei.controllers;

import com.togather.sensei.controllers.grupoController.BuscaTodosOsGruposController;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.BuscarTodosOsGruposService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals; // Corrigido para JUnit 5

@ExtendWith(SpringExtension.class)
class BuscarTodosOsGruposControllerTest {

    @Mock
    private BuscarTodosOsGruposService buscarTodosOsGruposService;

    @InjectMocks
    private BuscaTodosOsGruposController buscaTodosOsGruposController;

    @Test
    void getAllGrupos() {
        // Criando uma lista de grupos de exemplo
        GrupoModel grupo1 = new GrupoModel();
        grupo1.setId(1L);
        grupo1.setNome("Grupo 1");
        grupo1.setAtivo(true);

        GrupoModel grupo2 = new GrupoModel();
        grupo2.setId(2L);
        grupo2.setNome("Grupo 2");
        grupo2.setAtivo(true);

        List<GrupoModel> grupos = Arrays.asList(grupo1, grupo2);

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscarTodosOsGruposService.getAllGrupos()).thenReturn(grupos);

        // Chama o método a ser testado
        ResponseEntity<List<GrupoModel>> response = buscaTodosOsGruposController.getAllGrupos();

        // Verifica se a resposta tem o status HTTP 200 e se a lista de grupos está correta
        assertEquals(200, response.getStatusCodeValue()); // Verifica se o código de status é 200
        assertEquals(grupos, response.getBody()); // Verifica se o corpo da resposta contém a lista de grupos
    }
}
