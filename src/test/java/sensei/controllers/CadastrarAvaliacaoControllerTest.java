package sensei.controllers;

import com.togather.sensei.controllers.avaliacaoController.CadastrarAvaliacaoController;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.services.avaliacaoService.AvaliacaoPostService;
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
class CadastrarAvaliacaoControllerTest {

    @Mock
    private AvaliacaoPostService avaliacaoPostService;

    @InjectMocks
    private CadastrarAvaliacaoController cadastrarAvaliacaoController;

    @Test
    void dadoAvaliacaoModelValido_entaoRetorneCreated() {
        // Criação de um AvaliacaoModel de entrada
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
//        avaliacaoModel.s(1L);
        avaliacaoModel.setAbdominais(1);

        // Configuração do comportamento esperado do serviço
        Mockito.doNothing().when(avaliacaoPostService).saveAvaliacao(avaliacaoModel);

        // Chama o método a ser testado
        ResponseEntity<Void> response = cadastrarAvaliacaoController.cadastrarAvaliacaoModel(avaliacaoModel);

        // Assert
        // Verifica se o status da resposta é o esperado
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void dadoAvaliacaoModelInvalido_entaoRetorneHttpClientErrorException() {
        // Criação de um AvaliacaoModel inválido
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.doThrow(exception).when(avaliacaoPostService).saveAvaliacao(avaliacaoModel);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> cadastrarAvaliacaoController.cadastrarAvaliacaoModel(avaliacaoModel));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}
