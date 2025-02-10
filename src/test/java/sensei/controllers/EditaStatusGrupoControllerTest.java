package sensei.controllers;

import com.togather.sensei.controllers.grupoController.EditaStatusGrupoController;
import com.togather.sensei.services.grupoService.EditaGrupoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class EditaStatusGrupoControllerTest {

    @Mock
    private EditaGrupoService editaGrupoService;

    @InjectMocks
    private EditaStatusGrupoController editaStatusGrupoController;

    @Test
    void updateStatusGrupo() {
        Long grupoId = 1L;
        Boolean novoStatus = true;

        Mockito.doNothing().when(editaGrupoService).updateStatusGrupo(grupoId, novoStatus);

        // Chama o método do controlador
        ResponseEntity<String> response = editaStatusGrupoController.updateStatusGrupo(grupoId, novoStatus);

        // Verifica se a resposta tem o status HTTP 200 e se a mensagem é a esperada
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Status do grupo atualizado com sucesso", response.getBody());
    }
}
