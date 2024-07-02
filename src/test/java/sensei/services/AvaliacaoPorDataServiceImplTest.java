package sensei.services;

import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacaoPorDataServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AvaliacaoPorDataServiceImplTest {
    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoPorDataServiceImpl avaliacaoPorDataService;

    @Test
    void testBuscaAvaliacoes_Success() {
        List<String> datasEsperadas = Arrays.asList("2024-06-21", "2024-06-22");
        when(avaliacaoRepository.getAvaliacoesPorData()).thenReturn(datasEsperadas);

        List<String> datasRetornadas = avaliacaoPorDataService.buscaAvaliacoes();

        assertEquals(datasEsperadas, datasRetornadas);
    }
}