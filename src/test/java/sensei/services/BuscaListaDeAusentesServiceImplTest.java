package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaListaDeAusentesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BuscaListaDeAusentesServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private BuscaListaDeAusentesServiceImpl buscaListaDeAusentesService;

    @Test
    void getListaDeAusentes_DeveRetornarListaDeAtletasAusentes() {
        // Dados simulados
        AtletaModel atleta1 = new AtletaModel();
        atleta1.setId(1L);
        atleta1.setNome("Atleta 1");

        AtletaModel atleta2 = new AtletaModel();
        atleta2.setId(2L);
        atleta2.setNome("Atleta 2");

        List<AtletaModel> atletasAusentes = new ArrayList<>();
        atletasAusentes.add(atleta1);
        atletasAusentes.add(atleta2);

        // Configuração do comportamento esperado do repositório
        when(atletaRepository.buscaAusentesByData(LocalDate.now())).thenReturn(atletasAusentes);

        // Chamada do método a ser testado
        List<AtletaIdNomeDTO> result = buscaListaDeAusentesService.getListaDeAusentes();

        // Assert
        assertEquals(atletasAusentes.size(), result.size());
        assertEquals("Atleta 1", result.get(0).getNome());
        assertEquals("Atleta 2", result.get(1).getNome());
        // Adicione asserções adicionais conforme necessário
    }
}
