package sensei.controllers;

import com.togather.sensei.controllers.historicoLesoesController.EditarHistoricoLesoesController;
import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.services.EditarHistoricoLesoesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EditarHistoricoLesoesControllerTest {

    @Mock
    private EditarHistoricoLesoesService service;

    @InjectMocks
    private EditarHistoricoLesoesController controller;

    @Test
    void dadoAtualizarDeHistoricoLesao_entaoRetorneHistoricoAtualizado() {
        // Criação de um modelo de entrada e um modelo de resultado esperado
        HistoricoLesoesModel inputModel = new HistoricoLesoesModel();
        HistoricoLesoesModel expectedResult = new HistoricoLesoesModel();

        // Configuração do comportamento esperado do serviço
        Mockito.when(service.updateHistoricoLesao(inputModel)).thenReturn(expectedResult);

        // Chama o método a ser testado
        ResponseEntity<HistoricoLesoesModel> response = controller.atualizarHistoricoLesao(inputModel);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        Assertions.assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        Assertions.assertEquals(expectedResult, response.getBody());
    }
    @Test
    void dadoAtualizarDeHistoricoLesao_entaoRetorneHttpClientErrorException() {
        // Criação de um modelo de entrada
        HistoricoLesoesModel inputModel = new HistoricoLesoesModel();

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        Mockito.when(service.updateHistoricoLesao(inputModel)).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request"));

        // Verifica se o método lança a exceção esperada
        assertThrows(HttpClientErrorException.class, () -> controller.atualizarHistoricoLesao(inputModel));
    }
}
