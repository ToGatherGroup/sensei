package sensei.controllers;

import com.togather.sensei.dtos.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.controllers.avaliacaoController.BuscarAvaliacoesPorAtletaDataController;
import com.togather.sensei.services.avaliacaoService.BuscarAvaliacaoPorAtletaDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscaAvaliacaoByAtletaDataControllerTest {

    @Mock
    private BuscarAvaliacaoPorAtletaDataService buscarAvaliacaoPorAtletaDataService;

    @InjectMocks
    private BuscarAvaliacoesPorAtletaDataController buscarAvaliacoesPorAtletaDataController;

    @Test
    void buscarAvaliacoesPorAtletaDataController_DeveRetornarAvaliacaoModel() {
        // Criação de um ID de atleta e uma data de entrada, e uma lista de DTOs de avaliações de resultado esperado
        Long inputAtletaId = 1L;
        LocalDate inputData = LocalDate.of(2024, 5, 15);

        ResponseBuscaAvaliacaoDTO expectedResponse= new ResponseBuscaAvaliacaoDTO();

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscarAvaliacaoPorAtletaDataService.findAvaliacao(inputAtletaId, inputData)).thenReturn(expectedResponse);

        // Chama o método a ser testado
        ResponseEntity<ResponseBuscaAvaliacaoDTO> response = buscarAvaliacoesPorAtletaDataController.buscarAvaliacao(inputAtletaId, inputData);


        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
}

