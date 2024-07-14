package sensei.controllers;


import com.togather.sensei.controllers.avaliacaoController.AtualizaAvaliacaoController;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.services.avaliacaoService.AtualizaAvaliacaoService;
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

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class AtualizaAvaliacaoControllerTest {

    @Mock
    private AtualizaAvaliacaoService atualizaAvaliacaoService;

    @InjectMocks
    private AtualizaAvaliacaoController atualizaAvaliacaoController;
        @Test
        void dadoAtualizarAtleta_entaoRetorneAccepted() {
            // Criação de um modelo de entrada e um modelo de resultado esperado
            AtletaModel atleta = new AtletaModel();
            atleta.setId(1L);
            AvaliacaoModelId avaliacaoModelId = new AvaliacaoModelId(atleta,LocalDate.now());
            AvaliacaoModel inputModel = new AvaliacaoModel();
            inputModel.setAvaliacaoModelId(avaliacaoModelId);


            AvaliacaoModel expectedResult = new AvaliacaoModel();
            expectedResult.setAvaliacaoModelId(avaliacaoModelId);

            // Configuração do comportamento esperado do serviço
            Mockito.doNothing().when(atualizaAvaliacaoService).updateAvaliacao(inputModel);

            // Chama o método a ser testado
            ResponseEntity<Void> response = atualizaAvaliacaoController.alteraAvaliacao(inputModel);

            // Assert
            // Verifica se o status da resposta e o corpo são os esperados
            assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());


        }

        @Test
        void dadoAtualizarAtleta_entaoRetorneHttpClientErrorException() {
            AtletaModel atleta = new AtletaModel();
            atleta.setId(1L);
            AvaliacaoModelId avaliacaoModelId = new AvaliacaoModelId(atleta,LocalDate.now());
            AvaliacaoModel inputModel = new AvaliacaoModel();
            inputModel.setAvaliacaoModelId(avaliacaoModelId);


            AvaliacaoModel expectedResult = new AvaliacaoModel();
            expectedResult.setAvaliacaoModelId(avaliacaoModelId);

            // Configuração do comportamento esperado do serviço para lançar uma exceção
            HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
            Mockito.doThrow(exception).when(atualizaAvaliacaoService).updateAvaliacao(inputModel);

            // Verifica se o método lança a exceção esperada
            HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> atualizaAvaliacaoController.alteraAvaliacao(inputModel));

            // Verifica a mensagem da exceção
            assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
            assertEquals("400 400 Bad Request", thrown.getMessage());
        }
}

