package sensei.controllers;

import com.togather.sensei.controllers.avaliacaoposturalController.CadastraAvaliacaoPosturalController;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalPostService;
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
class CadastraAvaliacaoPosturalControllerTest {

    @Mock
    private AvaliacaoPosturalPostService avaliacaoPosturalPostService;

    @InjectMocks
    private CadastraAvaliacaoPosturalController cadastraAvaliacaoPosturalController;

    @Test
    void dadoAvaliacaoPosturalModelValido_entaoRetorneCreated() {
        // Criação de um AvaliacaoPosturalModel de entrada
       List<AvaliacaoPosturalModel> avaliacaoPosturalModel = new ArrayList<>();

        // Configuração do comportamento esperado do serviço
        Mockito.doNothing().when(avaliacaoPosturalPostService).saveAvaliacaoPostural(avaliacaoPosturalModel);

        // Chama o método a ser testado
        ResponseEntity<Void> response = cadastraAvaliacaoPosturalController.cadastraAvaliacaoPostural(avaliacaoPosturalModel);

        // Assert
        // Verifica se o status da resposta é o esperado
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void dadoAvaliacaoPosturalModelInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um AvaliacaoPosturalModel inválido
        List<AvaliacaoPosturalModel> avaliacaoPosturalModel = new ArrayList<>();

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.doThrow(exception).when(avaliacaoPosturalPostService).saveAvaliacaoPostural(avaliacaoPosturalModel);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> cadastraAvaliacaoPosturalController.cadastraAvaliacaoPostural(avaliacaoPosturalModel));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}

