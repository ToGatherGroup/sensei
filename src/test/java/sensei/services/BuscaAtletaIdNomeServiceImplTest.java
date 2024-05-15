package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaIdNomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscaAtletaIdNomeServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private BuscaAtletaIdNomeServiceImpl buscaAtletaIdNomeService;

    @Test
    void findAtletaIdNome_DeveRetornarListaAtletaIdNomeDTO() {
        // Dados de entrada simulados
        AtletaModel atleta1 = new AtletaModel();
        atleta1.setId(1L);
        atleta1.setNome("Atleta 1");

        AtletaModel atleta2 = new AtletaModel();
        atleta2.setId(2L);
        atleta2.setNome("Atleta 2");

        List<AtletaModel> atletaModelList = new ArrayList<>();
        atletaModelList.add(atleta1);
        atletaModelList.add(atleta2);

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findAll()).thenReturn(atletaModelList);

        // Mock do mapeador para converter AtletaModel em AtletaIdNomeDTO
        AtletaIdNomeDTO atletaIdNomeDTO1 = new AtletaIdNomeDTO();
        atletaIdNomeDTO1.setId(1L);
        atletaIdNomeDTO1.setNome("Atleta 1");

        AtletaIdNomeDTO atletaIdNomeDTO2 = new AtletaIdNomeDTO();
        atletaIdNomeDTO2.setId(2L);
        atletaIdNomeDTO2.setNome("Atleta 2");

        Mockito.when(mapper.map(atleta1, AtletaIdNomeDTO.class)).thenReturn(atletaIdNomeDTO1);
        Mockito.when(mapper.map(atleta2, AtletaIdNomeDTO.class)).thenReturn(atletaIdNomeDTO2);

        // Chama o método a ser testado
        List<AtletaIdNomeDTO> result = buscaAtletaIdNomeService.findAtletaIdNome();

        // Assert
        // Verifica se o tamanho da lista retornada é o esperado
        assertEquals(2, result.size());

        // Adicione asserções para verificar se os itens na lista estão corretos
        assertEquals(1L, result.get(0).getId());
        assertEquals("Atleta 1", result.get(0).getNome());

        assertEquals(2L, result.get(1).getId());
        assertEquals("Atleta 2", result.get(1).getNome());
    }
}
