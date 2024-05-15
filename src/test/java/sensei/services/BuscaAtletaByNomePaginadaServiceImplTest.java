package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaIdNomeFotoDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaByNomePaginadaServiceImpl;
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
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
class BuscaAtletaByNomePaginadaServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private BuscaAtletaByNomePaginadaServiceImpl buscaAtletaByNomePaginadaService;

    @Test
    void buscaNome_DeveRetornarPaginaDeAtletasDTO() {
        // Dados de entrada
        String nome = "João";
        Pageable pageable = Pageable.ofSize(10).withPage(0);

        // Lista de AtletaModel simulada
        List<AtletaModel> atletaModelList = new ArrayList<>();
        // Adicionar lógica para preencher a lista de atletas simulada com alguns atletas

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.buscaPorNome(nome, pageable)).thenReturn(new PageImpl<>(atletaModelList));

        // Configuração do comportamento esperado do Mapper
        Mockito.when(mapper.map(any(AtletaModel.class), any())).thenReturn(new AtletaIdNomeFotoDTO());
        // Adicionar lógica para configurar o comportamento do mapper conforme necessário

        // Chama o método a ser testado
        Page<AtletaIdNomeFotoDTO> result = buscaAtletaByNomePaginadaService.buscaNome(nome, pageable);

        // Assert
        // Verifica se o número de elementos na página é igual ao número de atletas simulados
        assertEquals(atletaModelList.size(), result.getContent().size());
        // Adicionar lógica para verificar outros aspectos da página, se necessário
    }
}

