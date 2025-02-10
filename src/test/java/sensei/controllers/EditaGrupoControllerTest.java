package sensei.controllers;

import com.togather.sensei.controllers.grupoController.EditaGrupoController;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.EditaGrupoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class EditaGrupoControllerTest {

    @Mock
    private EditaGrupoService editaGrupoService;

    @InjectMocks
    private EditaGrupoController editaGrupoController;

    @Test
    void updateGrupo() {
        // Criando o grupo de exemplo
        GrupoModel grupoInput = new GrupoModel();
        grupoInput.setId(1L);
        grupoInput.setNome("Grupo Atualizado");
        grupoInput.setIsAtivo(true);

        Mockito.when(editaGrupoService.updateGrupo(grupoInput)).thenReturn(grupoInput);

        // Chama o método do controlador
        ResponseEntity<GrupoModel> response = editaGrupoController.updateGrupo(grupoInput);

        // Verifica se a resposta tem o status HTTP 202 e se o grupo retornado é o esperado
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(grupoInput, response.getBody());
    }
}
