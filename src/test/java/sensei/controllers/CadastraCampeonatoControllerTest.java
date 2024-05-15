package sensei.controllers;

import com.togather.sensei.controllers.CampeonatoController.CadastraCampeonatoController;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.services.campeonatosService.CadastraCampeonatoService;
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
class CadastraCampeonatoControllerTest {

    @Mock
    private CadastraCampeonatoService cadastraCampeonatoService;

    @InjectMocks
    private CadastraCampeonatoController cadastraCampeonatoController;

    @Test
    void cadastraCampeonato_DeveRetornarCampeonato() {
        // Criação de um modelo de campeonato de entrada e de resultado esperado
        CampeonatosDisputadosModel inputModel = new CampeonatosDisputadosModel();
        inputModel.setId(1L);
        inputModel.setNome("Campeonato de Verão");

        CampeonatosDisputadosModel expectedCampeonato = new CampeonatosDisputadosModel();
        expectedCampeonato.setId(1L);
        expectedCampeonato.setNome("Campeonato de Verão");

        // Configuração do comportamento esperado do serviço
        Mockito.when(cadastraCampeonatoService.salvaCampeonato(inputModel)).thenReturn(expectedCampeonato);

        // Chama o método a ser testado
        ResponseEntity<CampeonatosDisputadosModel> response = cadastraCampeonatoController.cadastraCampeonato(inputModel);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCampeonato, response.getBody());
    }
}

