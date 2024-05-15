package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

import com.togather.sensei.DTO.geral.SeriesDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacoesPorAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AvaliacoesPorAtletaServiceImplTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private AvaliacoesPorAtletaServiceImpl avaliacoesPorAtletaService;

    @Test
    void getAvaliacoesPorAtleta_DeveRetornarSeriesDTOCorretamente() {
        // Defina o comportamento esperado para os repositórios mockados

        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNascimento(LocalDate.of(1982, 4, 6));

        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
        avaliacaoModel.setPrancha(Duration.ofMinutes(60));
        avaliacaoModel.setRmTerra(5);
        avaliacaoModel.setAbdominais(10);
        avaliacaoModel.setBurpees(10);
        avaliacaoModel.setAltura(1.70);
        avaliacaoModel.setFlexoes(5);
        avaliacaoModel.setCooper(0.5);
        avaliacaoModel.setPeso(65);
        avaliacaoModel.setForcaIsometricaMaos(Duration.ofMinutes(50));
        avaliacaoModel.setTesteDeLunge(4.0);
        avaliacaoModel.setImpulsaoVertical(5.0);

        when(atletaRepository.findById(1L)).thenReturn(Optional.of(atletaModel)); // Simula um atleta existente
        when(avaliacaoRepository.getLastAvaliacaoByAtleta(atletaModel.getId())).thenReturn(avaliacaoModel); // Simula uma avaliação existente

        // Chame o método a ser testado
        SeriesDTO seriesDTO = avaliacoesPorAtletaService.getAvaliacoesPorAtleta(atletaModel.getId());

        // Verifique se a SeriesDTO retornada não é nula
        assertNotNull(seriesDTO);

        // Verifique se os labels e valores foram configurados corretamente
        assertNotNull(seriesDTO.labels);
        assertNotNull(seriesDTO.values);
        assertEquals(9, seriesDTO.labels.length);
        assertEquals(9, seriesDTO.values.length);
        // Aqui você pode adicionar mais asserções para garantir que os valores retornados são os esperados
    }
}


