package sensei.controllers;

import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.controllers.avaliacaoController.AvaliacoesPorAtletaController;
import com.togather.sensei.services.avaliacaoService.AvaliacoesPorAtletaService;
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
class AvaliacoesPorAtletaControllerTest {

    @Mock
    private AvaliacoesPorAtletaService avaliacoesPorAtletaDataService;

    @InjectMocks
    private AvaliacoesPorAtletaController avaliacoesPorAtletaController;

    @Test
    void dadoAtletaIdValido_entaoRetorneSeriesDTO() {
        // Criação de um ID de atleta de entrada e um DTO de resultado esperado
        Long inputAtletaId = 1L;
        SeriesDTO expectedDTO = new SeriesDTO();

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacoesPorAtletaDataService.getAvaliacoesPorAtleta(inputAtletaId)).thenReturn(expectedDTO);

        // Chama o método a ser testado
        ResponseEntity<SeriesDTO> response = avaliacoesPorAtletaController.buscaAvaliacoesPorAtleta(inputAtletaId);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTO, response.getBody());
    }

    @Test
    void dadoAtletaIdInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um ID de atleta de entrada
        Long inputAtletaId = 1L;

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        Mockito.when(avaliacoesPorAtletaDataService.getAvaliacoesPorAtleta(inputAtletaId)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> avaliacoesPorAtletaController.buscaAvaliacoesPorAtleta(inputAtletaId));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}

