package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.controllers.atletaController.BuscaCardAtletaByIdController;
import com.togather.sensei.services.atletaService.BuscaCardAtletaByIdService;
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

@ExtendWith(SpringExtension.class)
class BuscaCardAtletaByIdControllerTest {

    @Mock
    private BuscaCardAtletaByIdService buscaAtletaByIdService;

    @InjectMocks
    private BuscaCardAtletaByIdController buscaCardAtletaByIdController;

    @Test
    void dadoIdValido_entaoRetorneAtletaCardDTO() {
        // Criação de um ID de entrada e um modelo de resultado esperado
        Long inputId = 1L;
        AtletaCardDTO expectedResult = new AtletaCardDTO();
//        expectedResult.setId(1L);
        expectedResult.setNome("Atleta 1");

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaAtletaByIdService.findAtletaCardById(inputId)).thenReturn(expectedResult);

        // Chama o método a ser testado
        ResponseEntity<AtletaCardDTO> response = buscaCardAtletaByIdController.buscaAtletabyId(inputId);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    void dadoIdInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um ID de entrada
        Long inputId = 1L;

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        Mockito.when(buscaAtletaByIdService.findAtletaCardById(inputId)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> buscaCardAtletaByIdController.buscaAtletabyId(inputId));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}

