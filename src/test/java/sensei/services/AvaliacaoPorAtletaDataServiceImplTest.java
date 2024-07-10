package sensei.services;

import com.togather.sensei.DTO.avaliacao.ListaExerciciosDTO;
import com.togather.sensei.DTO.avaliacao.ResponseBuscaAvaliacaoDTO;
import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.exceptions.BusinessException;
import com.togather.sensei.models.*;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacaoColetivaImpl;
import com.togather.sensei.services.avaliacaoService.impl.BuscarAvaliacaoPorAtletaDataServiceImpl;
import com.togather.sensei.services.avaliacaoposturalService.impl.AvaliacoesPosturaisByPosicaoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
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
        when(atletaRepository.findById(atletaId)).thenReturn(Optional.of(atleta));

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
        when(atletaRepository.findById(atletaId)).thenReturn(Optional.empty());

        // Verificação de que a exceção é lançada
        assertThrows(BusinessException.class, () -> {
            avaliacaoPorAtletaDataService.findAvaliacao(atletaId, data);
        });
    }


}

