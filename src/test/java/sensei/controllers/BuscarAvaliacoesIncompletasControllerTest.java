package sensei.controllers;

import com.togather.sensei.DTO.avaliacao.AvaliacaoIncompletaDTO;
import com.togather.sensei.controllers.avaliacaoController.BuscarAvaliacoesIncompletasController;
import com.togather.sensei.services.avaliacaoService.AvaliacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscarAvaliacoesIncompletasControllerTest {

    @Mock
    private AvaliacaoService avaliacaoService;

    @InjectMocks
    private BuscarAvaliacoesIncompletasController controller;

    @Test
    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaDeAvaliacoes() {
        // Criação de uma lista de avaliações incompletas esperada
        List<AvaliacaoIncompletaDTO> expectedAvaliacoes = new ArrayList<>();
        expectedAvaliacoes.add(new AvaliacaoIncompletaDTO());
        expectedAvaliacoes.add(new AvaliacaoIncompletaDTO());

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacaoService.buscaAvaliacoesIncompletas()).thenReturn(expectedAvaliacoes);

        // Chama o método a ser testado
        ResponseEntity<List<AvaliacaoIncompletaDTO>> response = controller.buscaAvaliacoesIncompletas();

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAvaliacoes, response.getBody());
    }

    @Test
    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaVazia() {
        // Criação de uma lista vazia de avaliações incompletas
        List<AvaliacaoIncompletaDTO> expectedAvaliacoes = new ArrayList<>();

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacaoService.buscaAvaliacoesIncompletas()).thenReturn(expectedAvaliacoes);

        // Chama o método a ser testado
        ResponseEntity<List<AvaliacaoIncompletaDTO>> response = controller.buscaAvaliacoesIncompletas();

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedAvaliacoes, response.getBody());
    }

    @Test
    void dadoErroNoServico_entaoLancaExcecao() {
        // Configuração do comportamento esperado do serviço para lançar uma exceção
        Mockito.when(avaliacaoService.buscaAvaliacoesIncompletas()).thenThrow(new RuntimeException("Erro no serviço"));

        // Verifica se o método lança a exceção esperada
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> controller.buscaAvaliacoesIncompletas());

        // Assert
        assertEquals("Erro no serviço", thrown.getMessage());
    }
}
