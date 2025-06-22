package sensei.controllers;

import com.togather.sensei.controllers.dadosqualitativosController.BuscaDadosQualitativosController;
import com.togather.sensei.dtos.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.services.dadosqualitativosService.BuscarDadosQualitativosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscaDadosQualitativosControllerTest {
    @Mock
    private BuscarDadosQualitativosService buscarDadosQualitativosService;

    @InjectMocks
    private BuscaDadosQualitativosController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscaDadosQualitativosPorAtleta_DeveRetornarOkQuandoSucesso() {
        Long atletaId = 1L;
        DadosQualitativosResponseDTO responseDTO = new DadosQualitativosResponseDTO();
        when(buscarDadosQualitativosService.buscaDadosQualitativos(atletaId)).thenReturn(responseDTO);

        ResponseEntity<DadosQualitativosResponseDTO> response = controller.buscaDadosQualitativosPorAtleta(atletaId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseDTO, response.getBody());
    }

    @Test
    void buscaDadosQualitativosPorAtleta_DeveLancarHttpClientErrorExceptionQuandoErro() {
        Long atletaId = 2L;
        when(buscarDadosQualitativosService.buscaDadosQualitativos(atletaId))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND, "Atleta não encontrado"));

        HttpClientErrorException ex = assertThrows(HttpClientErrorException.class, () ->
                controller.buscaDadosQualitativosPorAtleta(atletaId));
        assertEquals(HttpStatus.NOT_FOUND, ex.getStatusCode());
        assertEquals("404 Atleta não encontrado", ex.getStatusText());
    }
}

