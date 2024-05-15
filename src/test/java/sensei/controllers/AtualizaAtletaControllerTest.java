package sensei.controllers;

import com.togather.sensei.controllers.atletaController.AtualizaAtletaController;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.AtualizaAtletatService;
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
class AtualizaAtletaControllerTest {

    @Mock
    private AtualizaAtletatService atualizaAtletatService;

    @InjectMocks
    private AtualizaAtletaController atualizaAtletaController;

    @Test
    void dadoAtualizarAtleta_entaoRetorneAtletaAtualizado() {
        // Criação de um modelo de entrada e um modelo de resultado esperado
        AtletaModel inputModel = new AtletaModel();
        inputModel.setId(1L);
        inputModel.setNome("Atleta 1");

        AtletaModel expectedResult = new AtletaModel();
        expectedResult.setId(1L);
        expectedResult.setNome("Atleta Atualizado");

        // Configuração do comportamento esperado do serviço
        Mockito.when(atualizaAtletatService.updateAtleta(inputModel)).thenReturn(expectedResult);

        // Chama o método a ser testado
        ResponseEntity<AtletaModel> response = atualizaAtletaController.alteraAtleta(inputModel);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    void dadoAtualizarAtleta_entaoRetorneHttpClientErrorException() {
        // Criação de um modelo de entrada
        AtletaModel inputModel = new AtletaModel();
        inputModel.setId(1L);
        inputModel.setNome("Atleta 1");

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.when(atualizaAtletatService.updateAtleta(inputModel)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> atualizaAtletaController.alteraAtleta(inputModel));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}

