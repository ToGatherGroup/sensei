package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaCardComparativoDTO;
import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.impl.BuscaComparativoByIdServiceImpl;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacoesPorAtletaServiceImpl;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscaComparativoByIdServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private BuscaMedalhaService buscaMedalhaService;

    @Mock
    private AvaliacoesPorAtletaServiceImpl avaliacoesService;

    @InjectMocks
    private BuscaComparativoByIdServiceImpl buscaComparativoByIdService;

    private AvaliacaoModel avaliacaoModel;
    private List<MedalhaDTO> medalhas;
    private SeriesDTO seriesDTO;

    @BeforeEach
    void setUp() {
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNome("Atleta 1");
        atletaModel.setFoto("foto_atleta");
        atletaModel.setNascimento(LocalDate.of(1990, 1, 1));
        atletaModel.setFaixa("Preta");

        avaliacaoModel = new AvaliacaoModel();
        avaliacaoModel.setPeso(75.0);
        avaliacaoModel.setAltura(1.80);

        medalhas = Collections.emptyList();
        seriesDTO = new SeriesDTO();

        when(atletaRepository.findById(anyLong())).thenReturn(Optional.of(atletaModel));

    }

    @Test
    void dadoIdValido_entaoRetorneAtletaCardComparativoDTO() {

        when(avaliacaoRepository.getLastAvaliacaoByAtleta(anyLong())).thenReturn(avaliacaoModel);
        when(buscaMedalhaService.buscaMedalhasComparativo(anyLong())).thenReturn(medalhas);
        when(avaliacoesService.getAvaliacoesPorAtleta(anyLong())).thenReturn(seriesDTO);

        AtletaCardComparativoDTO result = buscaComparativoByIdService.findAtletaCardById(1L);

        assertEquals("Atleta 1", result.getNome());
        assertEquals(75.0, result.getPeso());
        assertEquals(1.80, result.getAltura());
        assertEquals("Preta", result.getFaixa());
        assertEquals(34, result.getIdade());
        assertEquals(Collections.emptyList(), result.getMedalhaDTO());
    }

    @Test
    void dadoIdInvalido_entaoRetorneNotFoundException() {
        when(atletaRepository.findById(anyLong())).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(NotFoundException.class, () ->
                buscaComparativoByIdService.findAtletaCardById(1L)
        );

        assertEquals("Atleta não encontrado", thrown.getMessage());
    }
}