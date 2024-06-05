package sensei.controllers;

import com.togather.sensei.controllers.avaliacaoController.ExcluirAvaliacaoMesmaDataController;
import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoMesmaDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@ExtendWith(SpringExtension.class)
class ExcluirAvaliacaoMesmaDataControllerTest {

    @Mock
    private DeletarAvaliacaoMesmaDataService deletarAvaliacaoMesmaDataService;

    @InjectMocks
    private ExcluirAvaliacaoMesmaDataController excluirAvaliacaoMesmaDataController;

    private LocalDate data;

    @BeforeEach
    public void setUp(){
        data = LocalDate.now();
    }

    @Test
    void dadoDataValida_entaoRetorneNoContent() {
        doNothing().when(deletarAvaliacaoMesmaDataService).deletaAvaliacaoMesmaData(data);

        ResponseEntity<Void> response = excluirAvaliacaoMesmaDataController.apagaAvaliacaoMesmaData(data);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void dadoDataInvalida_entaoRetorneHttpClientErrorException(){
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        doThrow(exception).when(deletarAvaliacaoMesmaDataService).deletaAvaliacaoMesmaData(data);

        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> excluirAvaliacaoMesmaDataController.apagaAvaliacaoMesmaData(data));

        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
    }
}
