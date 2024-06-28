package sensei.controllers;

import com.togather.sensei.DTO.avaliacao.ResponseAvaliacoesIncompletasDTO;
import com.togather.sensei.controllers.avaliacaoController.BuscarAvaliacoesIncompletasController;
import com.togather.sensei.services.avaliacaoService.AvaliacaoIncompletaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscarAvaliacoesIncompletasControllerTest {

    @Mock
    private AvaliacaoIncompletaService avaliacaoIncompletaService;

    @InjectMocks
    private BuscarAvaliacoesIncompletasController controller;

    @Test
    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaDeAvaliacoes() {
        // Criação de uma lista de avaliações incompletas esperada
        ResponseAvaliacoesIncompletasDTO expectedAvaliacoes = new ResponseAvaliacoesIncompletasDTO();

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacaoIncompletaService.buscaAvaliacoesIncompletas()).thenReturn(expectedAvaliacoes);

        // Chama o método a ser testado
        ResponseEntity<ResponseAvaliacoesIncompletasDTO> response = controller.buscaAvaliacoesIncompletas();

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAvaliacoes, response.getBody());
    }

    @Test
    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaVazia() {
        // Criação de uma lista vazia de avaliações incompletas
        ResponseAvaliacoesIncompletasDTO expectedAvaliacoes = new ResponseAvaliacoesIncompletasDTO();

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacaoIncompletaService.buscaAvaliacoesIncompletas()).thenReturn(expectedAvaliacoes);

        // Chama o método a ser testado
        ResponseEntity<ResponseAvaliacoesIncompletasDTO> response = controller.buscaAvaliacoesIncompletas();

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAvaliacoes, response.getBody());
    }

    @Test
    void dadoErroNoServico_entaoLancaExcecao() {
        // Configuração do comportamento esperado do serviço para lançar uma exceção
        Mockito.when(avaliacaoIncompletaService.buscaAvaliacoesIncompletas()).thenThrow(new RuntimeException("Erro no serviço"));

        // Verifica se o método lança a exceção esperada
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> controller.buscaAvaliacoesIncompletas());

        // Assert
        assertEquals("Erro no serviço", thrown.getMessage());
    }
}