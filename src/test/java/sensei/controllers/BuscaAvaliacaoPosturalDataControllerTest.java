package sensei.controllers;

import com.togather.sensei.controllers.avaliacaoposturalController.BuscaAvaliacaoPosturalDataController;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacaoPosturalGetDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscaAvaliacaoPosturalDataControllerTest {

    @Mock
    private AvaliacaoPosturalGetDataService avaliacaoPosturalGetDataService;

    @InjectMocks
    private BuscaAvaliacaoPosturalDataController buscaAvaliacaoPosturalDataController;

    @Test
    void buscaAvaliacaoDataId_DeveRetornarListaDeDatas() {
        // Criação de um ID de atleta de entrada e uma lista de datas de resultado esperado
        Long inputAtletaId = 1L;
        List<LocalDate> expectedDates = new ArrayList<>();
        expectedDates.add(LocalDate.of(2024, 5, 1));
        expectedDates.add(LocalDate.of(2024, 5, 15));

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacaoPosturalGetDataService.buscarDatasDeAvaliacoesPorAtletaId(inputAtletaId)).thenReturn(expectedDates);

        // Chama o método a ser testado
        ResponseEntity<List<LocalDate>> response = buscaAvaliacaoPosturalDataController.buscaAvaliacaoDataId(inputAtletaId);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDates, response.getBody());
    }
}

