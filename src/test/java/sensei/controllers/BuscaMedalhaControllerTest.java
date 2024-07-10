package sensei.controllers;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.controllers.campeonatoController.BuscaMedalhaController;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
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
class BuscaMedalhaControllerTest {

    @Mock
    private BuscaMedalhaService buscaMedalhaService;

    @InjectMocks
    private BuscaMedalhaController buscaMedalhaController;

    @Test
    void cadastraCampeonato_DeveRetornarListaDeMedalhas() {
        // Criação de um ID de atleta de entrada e uma lista de medalhas de resultado esperado
        Long inputAtletaId = 1L;
        List<MedalhaDTO> expectedMedals = new ArrayList<>();
        expectedMedals.add(new MedalhaDTO("Ouro", 2));
        expectedMedals.add(new MedalhaDTO("Prata", 2));

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaMedalhaService.buscaMedalhas(inputAtletaId)).thenReturn(expectedMedals);

        // Chama o método a ser testado
        ResponseEntity<List<MedalhaDTO>> response = buscaMedalhaController.cadastraCampeonato(inputAtletaId);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMedals, response.getBody());
    }
}

