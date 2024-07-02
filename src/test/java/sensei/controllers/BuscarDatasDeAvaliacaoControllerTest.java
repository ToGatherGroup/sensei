package sensei.controllers;

import com.togather.sensei.controllers.avaliacaoController.BuscarDatasDeAvaliacaoController;
import com.togather.sensei.services.avaliacaoService.AvaliacaoPorDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BuscarDatasDeAvaliacaoControllerTest {
    @Mock
    private AvaliacaoPorDataService avaliacaoPorDataService;

    @InjectMocks
    private BuscarDatasDeAvaliacaoController controller;

    @Test
    void testBuscaDatasDeAvaliacao_Success() {
        List<String> datas = Arrays.asList("2024-06-21", "2024-06-22");
        when(avaliacaoPorDataService.buscaAvaliacoes()).thenReturn(datas);

        ResponseEntity<List<String>> response = controller.buscaDatasDeAvaliacao();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(datas, response.getBody());
    }

    @Test
    void testBuscaDatasDeAvaliacao_Failure() {
        when(avaliacaoPorDataService.buscaAvaliacoes())
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Erro na requisição"));

        try {
            controller.buscaDatasDeAvaliacao();
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
            assertEquals("400 400 Erro na requisição", e.getMessage());
        }
    }
}