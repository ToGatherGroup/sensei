package sensei.controllers;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;
import com.togather.sensei.controllers.presencaController.PresencasDeAtletaController;
import com.togather.sensei.services.presencaService.PresencasDeAtletaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class PresencasDeAtletaControllerTest {

    @Mock
    private PresencasDeAtletaService presencasDeAtletaService;

    @InjectMocks
    private PresencasDeAtletaController presencasDeAtletaController;

    @Test
    void presencasDeAtleta_DeveRetornarPresencasDTO() {
        // Dados de entrada
        Long idAtleta = 1L;
        LocalDate dataInicio = LocalDate.of(2024, 5, 1);
        LocalDate dataFim = LocalDate.of(2024, 5, 15);

        // Objeto de PresencaAtletaDTO esperado
        PresencaAtletaDTO expectedPresencas = new PresencaAtletaDTO();
        // Adicionar lógica para configurar o objeto expectedPresencas com valores de teste

        // Configuração do comportamento esperado do serviço
        Mockito.when(presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta, dataInicio, dataFim)).thenReturn(expectedPresencas);

        // Chama o método a ser testado
        ResponseEntity<PresencaAtletaDTO> response = presencasDeAtletaController.presencasDeAtleta(idAtleta, dataInicio, dataFim);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPresencas, response.getBody());
    }

    @Test
    void presencasDeAtleta_DeveRetornarHttpClientErrorException() {
        // Dados de entrada
        Long idAtleta = 1L;
        LocalDate dataInicio = LocalDate.of(2024, 5, 1);
        LocalDate dataFim = LocalDate.of(2024, 5, 15);

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        Mockito.when(presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta, dataInicio, dataFim)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> presencasDeAtletaController.presencasDeAtleta(idAtleta, dataInicio, dataFim));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}
