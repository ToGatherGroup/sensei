package sensei.controllers;

import com.togather.sensei.controllers.presencaController.ChamadaDeAtletaController;
import com.togather.sensei.services.presencaService.ChamadaDeAtletaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class ChamadaDeAtletaControllerTest {

    @Mock
    private ChamadaDeAtletaService chamadaDeAtletaService;

    @InjectMocks
    private ChamadaDeAtletaController chamadaDeAtletaController;

    @Test
    void chamadaDeAtleta_DeveRetornarNoContent() {
        // Criação de uma lista de IDs de atleta de entrada
        List<Long> inputIdAtletaList = Arrays.asList(1L, 2L, 3L);

        // Configuração do comportamento esperado do serviço
        Mockito.doNothing().when(chamadaDeAtletaService).chamadaDeAtleta(inputIdAtletaList);

        // Chama o método a ser testado
        ResponseEntity<Void> response = chamadaDeAtletaController.chamadaDeAtleta(inputIdAtletaList);

        // Assert
        // Verifica se o status da resposta é o esperado
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void chamadaDeAtleta_DeveRetornarHttpClientErrorException() {
        // Criação de uma lista de IDs de atleta de entrada
        List<Long> inputIdAtletaList = Arrays.asList(1L, 2L, 3L);

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.doThrow(exception).when(chamadaDeAtletaService).chamadaDeAtleta(inputIdAtletaList);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> chamadaDeAtletaController.chamadaDeAtleta(inputIdAtletaList));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}

