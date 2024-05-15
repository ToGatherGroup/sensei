package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.controllers.atletaController.BuscaListaDeAusentesController;
import com.togather.sensei.services.atletaService.BuscaListaDeAusentesService;
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
class BuscaListaDeAusentesControllerTest {

    @Mock
    private BuscaListaDeAusentesService buscaListaDeAusentesService;

    @InjectMocks
    private BuscaListaDeAusentesController buscaListaDeAusentesController;

    @Test
    void buscaListadeAusentes_DeveRetornarListaDeAusentes() {
        // Criação de uma lista de atletas ausentes esperada
        List<AtletaIdNomeDTO> expectedList = new ArrayList<>();
        expectedList.add(new AtletaIdNomeDTO(1L, "Atleta 1"));
        expectedList.add(new AtletaIdNomeDTO(2L, "Atleta 2"));

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaListaDeAusentesService.getListaDeAusentes()).thenReturn(expectedList);

        // Chama o método a ser testado
        ResponseEntity<List<AtletaIdNomeDTO>> response = buscaListaDeAusentesController.buscaListadeAusentes();

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());
    }
}
