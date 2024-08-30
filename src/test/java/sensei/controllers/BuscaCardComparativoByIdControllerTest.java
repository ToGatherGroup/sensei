package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaCardComparativoDTO;
import com.togather.sensei.controllers.atletaController.BuscaCardComparativoByIdController;
import com.togather.sensei.services.atletaService.BuscaComparativoAtletaByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaCardComparativoByIdControllerTest {

    @Mock
    private BuscaComparativoAtletaByIdService buscaComparativoByIdService;

    @InjectMocks
    private BuscaCardComparativoByIdController buscaCardComparativoByIdController;

    @Test
    void dadoIdValido_entaoRetorneAtletaCardComparativoDTO() {
        Long inputId = 1L;
        AtletaCardComparativoDTO expectedResult = new AtletaCardComparativoDTO();
        expectedResult.setNome("Atleta Comparativo 1");

        when(buscaComparativoByIdService.findAtletaCardById(inputId)).thenReturn(expectedResult);

        ResponseEntity<AtletaCardComparativoDTO> response = buscaCardComparativoByIdController.buscaComparativoById(inputId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    void dadoIdInvalido_entaoRetorneHttpClientErrorException() {
        Long inputId = 1L;

        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
        when(buscaComparativoByIdService.findAtletaCardById(inputId)).thenThrow(exception);

        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () ->
                buscaCardComparativoByIdController.buscaComparativoById(inputId)
        );

        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
        assertEquals("404 404 Not Found", thrown.getMessage());
    }
}