package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.controllers.atletaController.BuscaAtletaPaginadaController;
import com.togather.sensei.services.atletaService.BuscaAtletaPaginadaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class BuscaAtletaPaginadaControllerTest {

    @Mock
    private BuscaAtletaPaginadaService buscaAtletaPaginadaService;

    @InjectMocks
    private BuscaAtletaPaginadaController buscaAtletaPaginadaController;

    @Test
    void dadoPaginaValida_entaoRetornePaginaDeAtletas() {
        // Criação de uma página de resultado esperado
        Pageable pageable = PageRequest.of(0, 16, Sort.by("nome"));
        AtletaIdNomeFotoDTO atletaDTO = new AtletaIdNomeFotoDTO();
        atletaDTO.setId(1L);
        atletaDTO.setNome("Atleta 1");
        atletaDTO.setFoto("foto_url");
        Page<AtletaIdNomeFotoDTO> expectedPage = new PageImpl<>(Collections.singletonList(atletaDTO), pageable, 1);

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaAtletaPaginadaService.buscaAtletas(pageable)).thenReturn(expectedPage);

        // Chama o método a ser testado
        ResponseEntity<Page<AtletaIdNomeFotoDTO>> response = buscaAtletaPaginadaController.findAllAtleta(pageable);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());
    }

    @Test
    void dadoPaginaValida_entaoRetornePaginaVazia() {
        // Criação de uma página vazia de resultado esperado
        Pageable pageable = PageRequest.of(0, 16, Sort.by("nome"));
        Page<AtletaIdNomeFotoDTO> expectedPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaAtletaPaginadaService.buscaAtletas(pageable)).thenReturn(expectedPage);

        // Chama o método a ser testado
        ResponseEntity<Page<AtletaIdNomeFotoDTO>> response = buscaAtletaPaginadaController.findAllAtleta(pageable);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());
    }

    @Test
    void dadoErroNoServico_entaoLancaHttpClientErrorException() {
        // Criação de um pageable de entrada
        Pageable pageable = PageRequest.of(0, 16, Sort.by("nome"));

        // Configuração do comportamento esperado do serviço para lançar uma exceção
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");
        Mockito.when(buscaAtletaPaginadaService.buscaAtletas(pageable)).thenThrow(exception);

        // Verifica se o método lança a exceção esperada
        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> buscaAtletaPaginadaController.findAllAtleta(pageable));

        // Verifica a mensagem da exceção
        assertEquals(HttpStatus.BAD_REQUEST, thrown.getStatusCode());
        assertEquals("400 400 Bad Request", thrown.getMessage());
    }
}

