package sensei.services;

import com.togather.sensei.dtos.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.dtos.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.*;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.BuscarAvaliacaoPorAtletaDataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AvaliacaoPorAtletaDataServiceImplTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private BuscarAvaliacaoPorAtletaDataServiceImpl avaliacaoPorAtletaDataService;

    @Test
    void buscarAvaliacaoByAtletaData_DeveRetornarAvaliacaoDtoCorretamente() {
        Long atletaId = 1L;
        LocalDate data = LocalDate.now();
        AtletaModel atleta = new AtletaModel();
        atleta.setId(atletaId);

        AvaliacaoModel avaliacao = new AvaliacaoModel();
        ListaExerciciosDTO listaExercicios = new ListaExerciciosDTO();
        ResponseBuscaAvaliacaoDTO expectedResponse = new ResponseBuscaAvaliacaoDTO(atletaId, data, listaExercicios);

        // Mock do comportamento do atletaRepository
        when(atletaRepository.existsById(atletaId)).thenReturn(true);

        // Mock do comportamento do avaliacaoRepository
        when(avaliacaoRepository.buscaAvaliacaoAtletaData(data, atletaId)).thenReturn(avaliacao);

        // Mock do comportamento do modelMapper
        when(modelMapper.map(avaliacao, ListaExerciciosDTO.class)).thenReturn(listaExercicios);


        // Chamada do método a ser testado
        ResponseBuscaAvaliacaoDTO result = avaliacaoPorAtletaDataService.findAvaliacao(atletaId, data);

        // Verificação do resultado
        Assertions.assertNotNull(result);
        assertEquals(expectedResponse.getAtletaId(), result.getAtletaId());
        assertEquals(expectedResponse.getData(), result.getData());
        assertEquals(expectedResponse.getExercicios(), result.getExercicios());
    }

    @Test
    void buscarAvaliacaoByAtletaData_AtletaNaoEncontrado_DeveLancarExcecao() {
        Long atletaId = 1L;
        LocalDate data = LocalDate.now();

        // Mock do comportamento do atletaRepository para retornar vazio
        when(atletaRepository.existsById(atletaId)).thenReturn(false);

        // Verificação de que a exceção é lançada
        assertThrows(BusinessException.class, () -> {
            avaliacaoPorAtletaDataService.findAvaliacao(atletaId, data);
        });
    }


}

