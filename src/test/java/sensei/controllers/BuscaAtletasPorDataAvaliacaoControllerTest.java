package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.controllers.atletaController.BuscaAtletasPorDataAvaliacaoController;
import com.togather.sensei.services.atletaService.BuscaAtletaPorDataAvaliacaoService;
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
class BuscaAtletasPorDataAvaliacaoControllerTest {

    @Mock
    private BuscaAtletaPorDataAvaliacaoService buscaAtletaPorDataAvaliacaoService;

    @InjectMocks
    private BuscaAtletasPorDataAvaliacaoController buscaAtletasPorDataAvaliacaoController;

    @Test
    void buscaListadeAtletasIdNome_DeveRetornarListadeAtletasIdNome(){

        List<AtletaIdNomeDTO> expectedList= new ArrayList<>();
        expectedList.add(new AtletaIdNomeDTO(1L,"Maico"));
        expectedList.add(new AtletaIdNomeDTO(2L,"Michel"));

        Mockito.when(buscaAtletaPorDataAvaliacaoService.findAllAtletasbyData(LocalDate.parse("2024-05-21"))).thenReturn(expectedList);

        ResponseEntity<List<AtletaIdNomeDTO>> response = buscaAtletasPorDataAvaliacaoController.buscaAtletasbyData(LocalDate.parse("2024-05-21"));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());
    }
}