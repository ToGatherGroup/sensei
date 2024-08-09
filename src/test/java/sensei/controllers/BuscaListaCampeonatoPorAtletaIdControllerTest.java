package sensei.controllers;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.controllers.campeonatoController.BuscaListaCampeonatoPorAtletaIdController;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.services.campeonatosService.BuscaListaCampeonatoPorAtletaIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BuscaListaCampeonatoPorAtletaIdControllerTest {

    @Mock
    private BuscaListaCampeonatoPorAtletaIdService listaCampeonatoPorAtletaIdService;

    @InjectMocks
    private BuscaListaCampeonatoPorAtletaIdController listaCampeonatoPorAtletaIdController;

    @Test
    void listaCampeonatos_DeveRetornarListaDeCampeonatos() {
        Long inputAtletaId = 1L;
        ListaCampeonatoDTO listaCampeonatoDTO = new ListaCampeonatoDTO();
        listaCampeonatoDTO.setNome("Campeonato 1");
        listaCampeonatoDTO.setPosicaoPodium(PosicaoEnum.PRIMEIRO);
        listaCampeonatoDTO.setData(LocalDate.now());
        List<ListaCampeonatoDTO> expectedCampeonatos = new ArrayList<>();
        expectedCampeonatos.add(listaCampeonatoDTO);

        when(listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(inputAtletaId))
                .thenReturn(expectedCampeonatos);

        ResponseEntity<List<ListaCampeonatoDTO>> response = listaCampeonatoPorAtletaIdController.listaCampeonatos(inputAtletaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCampeonatos, response.getBody());
    }

    @Test
    void listaCampeonatos_DeveRetornarListaVaziaQuandoNaoHouverCampeonatos() {
        Long inputAtletaId = 1L;
        List<ListaCampeonatoDTO> expectedCampeonatos = new ArrayList<>();

        when(listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(inputAtletaId))
                .thenReturn(expectedCampeonatos);

        ResponseEntity<List<ListaCampeonatoDTO>> response = listaCampeonatoPorAtletaIdController.listaCampeonatos(inputAtletaId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCampeonatos, response.getBody());
    }

    @Test
    void listaCampeonatos_DeveRetornarListaVaziaQuandoIdInvalido() {
        Long inputAtletaId = -1L; // ID inválido ou não encontrado
        List<ListaCampeonatoDTO> expectedCampeonatos = new ArrayList<>();

        when(listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(inputAtletaId))
                .thenReturn(expectedCampeonatos);

        ResponseEntity<List<ListaCampeonatoDTO>> response = listaCampeonatoPorAtletaIdController.listaCampeonatos(inputAtletaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCampeonatos, response.getBody());
    }
}