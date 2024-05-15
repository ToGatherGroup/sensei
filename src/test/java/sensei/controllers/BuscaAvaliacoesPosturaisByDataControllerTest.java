package sensei.controllers;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.controllers.avaliacaoposturalController.BuscaAvaliacoesPosturaisByDataController;
import com.togather.sensei.services.avaliacaoposturalService.AvaliacoesPosturaisByDataService;
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
class BuscaAvaliacoesPosturaisByDataControllerTest {

    @Mock
    private AvaliacoesPosturaisByDataService avaliacoesPosturaisByDataService;

    @InjectMocks
    private BuscaAvaliacoesPosturaisByDataController buscaAvaliacoesPosturaisByDataController;

    @Test
    void buscarAvaliacoesPosturaisByData_DeveRetornarListaDeAvaliacoes() {
        // Criação de um ID de atleta e uma data de entrada, e uma lista de DTOs de avaliações de resultado esperado
        Long inputAtletaId = 1L;
        LocalDate inputData = LocalDate.of(2024, 5, 15);
        List<AvaliacaoPosturalDTO> expectedDTOs = new ArrayList<>();
        expectedDTOs.add(new AvaliacaoPosturalDTO());
        expectedDTOs.add(new AvaliacaoPosturalDTO());

        // Configuração do comportamento esperado do serviço
        Mockito.when(avaliacoesPosturaisByDataService.buscarAvaliacoesPosturalByData(inputAtletaId, inputData)).thenReturn(expectedDTOs);

        // Chama o método a ser testado
        ResponseEntity<List<AvaliacaoPosturalDTO>> response = buscaAvaliacoesPosturaisByDataController.buscarAvaliacoesPosturaisByData(inputAtletaId, inputData);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTOs, response.getBody());
    }
}

