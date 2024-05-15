package sensei.controllers;

import com.togather.sensei.controllers.atletaController.DeletaAtletaByIdController;
import com.togather.sensei.services.atletaService.DeletaAtletaByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

@ExtendWith(SpringExtension.class)
class DeletaAtletaByIdControllerTest {

    @Mock
    private DeletaAtletaByIdService deletaAtletaByIdService;

    @InjectMocks
    private DeletaAtletaByIdController deletaAtletaByIdController;

    @Test
    void dadoIdValido_entaoRetorneNoContent() {
        // Criação de um ID de entrada
        Long inputId = 1L;

        // Configuração do comportamento esperado do serviço
        Mockito.doNothing().when(deletaAtletaByIdService).deleteAtletaById(inputId);

        // Chama o método a ser testado
        ResponseEntity<Void> response = deletaAtletaByIdController.apagaAtletaById(inputId);

        // Assert
        // Verifica se o status da resposta é o esperado
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void dadoIdInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um ID de entrada
        Long inputId = 1L;

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        Mockito.doThrow(exception).when(deletaAtletaByIdService).deleteAtletaById(inputId);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> deletaAtletaByIdController.apagaAtletaById(inputId));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}

