package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.controllers.atletaController.CadastraAtletaController;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.services.atletaService.AtletaPostService;
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
class CadastraAtletaControllerTest {

    @Mock
    private AtletaPostService atletaPostService;

    @InjectMocks
    private CadastraAtletaController cadastraAtletaController;

    @Test
    void dadoAtletaDTOValido_entaoRetorneAtletaModelCriado() {
        // Criação de um AtletaDTO de entrada e um AtletaModel de resultado esperado
        AtletaDTO atletaDTO = new AtletaDTO();
        atletaDTO.setNome("Novo Atleta");

        AtletaModel expectedResult = new AtletaModel();
        expectedResult.setId(1L);
        expectedResult.setNome("Novo Atleta");

        // Configuração do comportamento esperado do serviço
        Mockito.when(atletaPostService.saveAtleta(atletaDTO)).thenReturn(expectedResult);

        // Chama o método a ser testado
        ResponseEntity<AtletaModel> response = cadastraAtletaController.cadastraAtleta(atletaDTO);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    void dadoAtletaDTOInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um AtletaDTO inválido
        AtletaDTO atletaDTO = new AtletaDTO();

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.when(atletaPostService.saveAtleta(atletaDTO)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> cadastraAtletaController.cadastraAtleta(atletaDTO));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}

