package sensei.controllers;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.controllers.atletaController.BuscaAtletaNomePaginadaController;
import com.togather.sensei.services.atletaService.BuscaAtletaByNomePaginadaService;
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

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscaAtletaNomePaginadaControllerTest {

    @Mock
    private BuscaAtletaByNomePaginadaService buscaService;

    @InjectMocks
    private BuscaAtletaNomePaginadaController buscaAtletaNomePaginadaController;

    @Test
    void dadoNomeValido_entaoRetornePaginaDeAtletas() {
        // Criação de um nome de entrada e uma página de resultado esperado
        String nome = "Atleta";
        Pageable pageable = PageRequest.of(0, 16, Sort.by("nome"));
        AtletaIdNomeFotoDTO atletaDTO = new AtletaIdNomeFotoDTO();
        atletaDTO.setId(1L);
        atletaDTO.setNome("Atleta 1");
        atletaDTO.setFoto("foto_url");
        Page<AtletaIdNomeFotoDTO> expectedPage = new PageImpl<>(Collections.singletonList(atletaDTO), pageable, 1);

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaService.buscaNome(nome, pageable)).thenReturn(expectedPage);

        // Chama o método a ser testado
        ResponseEntity<Page<AtletaIdNomeFotoDTO>> response = buscaAtletaNomePaginadaController.buscaAtletaNome(nome, pageable);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());
    }

    @Test
    void dadoNomeInvalido_entaoRetornePaginaVazia() {
        // Criação de um nome de entrada e uma página vazia de resultado esperado
        String nome = "NomeInvalido";
        Pageable pageable = PageRequest.of(0, 16, Sort.by("nome"));
        Page<AtletaIdNomeFotoDTO> expectedPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        // Configuração do comportamento esperado do serviço
        Mockito.when(buscaService.buscaNome(nome, pageable)).thenReturn(expectedPage);

        // Chama o método a ser testado
        ResponseEntity<Page<AtletaIdNomeFotoDTO>> response = buscaAtletaNomePaginadaController.buscaAtletaNome(nome, pageable);

        // Assert
        // Verifica se o status da resposta e o corpo são os esperados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPage, response.getBody());
    }
}
