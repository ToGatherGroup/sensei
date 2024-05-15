package sensei.services;

import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.impl.AvaliacaoPosturalGetDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AvaliacaoPosturalGetDataServiceImplTest {

    @Mock
    private AvaliacaoPosturalRepository avaliacaoPosturalRepository;

    @InjectMocks
    private AvaliacaoPosturalGetDataServiceImpl avaliacaoPosturalGetDataService;

    @Test
    void buscarDatasDeAvaliacoesPorAtletaId_DeveRetornarListaDeDatasCorretamente() {
        // Dado um ID de atleta
        Long atletaId = 1L;

        // Datas simuladas retornadas pelo repositório
        List<LocalDate> datasSimuladas = Arrays.asList(
                LocalDate.of(2022, 5, 10),
                LocalDate.of(2022, 6, 15),
                LocalDate.of(2022, 7, 20)
        );

        // Configuração do comportamento esperado do repositório
        when(avaliacaoPosturalRepository.buscarDatasDeAvaliacoesPorAtletaId(atletaId)).thenReturn(datasSimuladas);

        // Chamada do método a ser testado
        List<LocalDate> result = avaliacaoPosturalGetDataService.buscarDatasDeAvaliacoesPorAtletaId(atletaId);

        // Verificação se a lista retornada contém as mesmas datas simuladas
        assertEquals(datasSimuladas, result);
    }
}
