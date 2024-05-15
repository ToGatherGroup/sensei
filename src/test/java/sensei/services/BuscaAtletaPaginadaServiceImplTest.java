package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaPaginadaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class BuscaAtletaPaginadaServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private BuscaAtletaPaginadaServiceImpl buscaAtletaPaginadaService;

    @Test
    void buscaAtletas_DeveRetornarPaginaDeAtletasDTO() {
        // Dados simulados
        AtletaModel atleta1 = new AtletaModel();
        atleta1.setId(1L);
        atleta1.setNome("Atleta 1");

        AtletaModel atleta2 = new AtletaModel();
        atleta2.setId(2L);
        atleta2.setNome("Atleta 2");

        List<AtletaModel> atletaModelList = new ArrayList<>();
        atletaModelList.add(atleta1);
        atletaModelList.add(atleta2);

        Pageable pageable = Pageable.ofSize(10).withPage(0);
        Page<AtletaModel> atletaModelPage = new PageImpl<>(atletaModelList, pageable, atletaModelList.size());

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findAll(pageable)).thenReturn(atletaModelPage);

        // Configuração do comportamento esperado do mapeador
        AtletaIdNomeFotoDTO atletaDTO1 = new AtletaIdNomeFotoDTO();
        atletaDTO1.setId(1L);
        atletaDTO1.setNome("Atleta 1");

        AtletaIdNomeFotoDTO atletaDTO2 = new AtletaIdNomeFotoDTO();
        atletaDTO2.setId(2L);
        atletaDTO2.setNome("Atleta 2");

        List<AtletaIdNomeFotoDTO> atletaDTOList = new ArrayList<>();
        atletaDTOList.add(atletaDTO1);
        atletaDTOList.add(atletaDTO2);

        Mockito.when(modelMapper.map(atleta1, AtletaIdNomeFotoDTO.class)).thenReturn(atletaDTO1);
        Mockito.when(modelMapper.map(atleta2, AtletaIdNomeFotoDTO.class)).thenReturn(atletaDTO2);

        // Chamada do método a ser testado
        Page<AtletaIdNomeFotoDTO> result = buscaAtletaPaginadaService.buscaAtletas(pageable);

        // Assert
        assertEquals(atletaModelList.size(), result.getContent().size());
        assertEquals(atletaDTOList, result.getContent());
        // Adicione asserções para verificar outros aspectos da página, se necessário
    }
}
