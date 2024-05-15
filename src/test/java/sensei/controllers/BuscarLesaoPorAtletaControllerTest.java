package sensei.controllers;

import com.togather.sensei.controllers.lesaoController.BuscarLesaoPorAtletaController;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.BuscarHistoricoLesoesPorAtletaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class BuscarLesaoPorAtletaControllerTest {

    @Mock
    private BuscarHistoricoLesoesPorAtletaService buscarHistoricoLesoesPorAtletaService;

    @InjectMocks
    private BuscarLesaoPorAtletaController buscarLesaoPorAtletaController;

    @Test
    void historicoDeLesoesPorAtleta_DeveRetornarListaDeLesoes() {
        // Criação de um ID de atleta de entrada e uma lista de lesões de resultado esperado
        long inputAtletaId = 1L;
        List<LesaoModel> expectedLesoes = new ArrayList<>();

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscarHistoricoLesoesPorAtletaService.buscaHistoricoLesoes(inputAtletaId)).thenReturn(expectedLesoes);

        // Chama o método a ser testado
        ResponseEntity<List<LesaoModel>> response = buscarLesaoPorAtletaController.historicoDeLesoesPorAtleta(inputAtletaId);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedLesoes, response.getBody());
    }

    @Test
    void historicoDeLesoesPorAtleta_DeveRetornarHttpClientErrorException() {
        // Criação de um ID de atleta de entrada
        long inputAtletaId = 1L;

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        Mockito.when(buscarHistoricoLesoesPorAtletaService.buscaHistoricoLesoes(inputAtletaId)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> buscarLesaoPorAtletaController.historicoDeLesoesPorAtleta(inputAtletaId));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}
