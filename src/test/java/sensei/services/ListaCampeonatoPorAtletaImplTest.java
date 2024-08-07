package sensei.services;

import com.togather.sensei.DTO.campeonato.ListaCampeonatoDTO;
import com.togather.sensei.enums.PosicaoEnum;
import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.impl.ListaCampeonatoPorAtletaIdServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListaCampeonatoPorAtletaImplTest {

    @Mock
    private CampeonatosRepository campeonatosRepository;

    @InjectMocks
    private ListaCampeonatoPorAtletaIdServiceImpl listaCampeonatoPorAtletaIdService;

    @Test
    void listaCampeonatosPorAtletaId_DeveRetornarListaDeCampeonatosCorretamente() {
        List<CampeonatosDisputadosModel> campeonatos = new ArrayList<>();
        CampeonatosDisputadosModel campeonato1 = new CampeonatosDisputadosModel();
        campeonato1.setNome("Campeonato A");
        campeonato1.setPosicaoPodium(PosicaoEnum.PRIMEIRO);
        campeonato1.setData(LocalDate.of(2023, 1, 15));

        CampeonatosDisputadosModel campeonato2 = new CampeonatosDisputadosModel();
        campeonato2.setNome("Campeonato B");
        campeonato2.setPosicaoPodium(PosicaoEnum.SEGUNDO);
        campeonato2.setData(LocalDate.of(2023, 2, 20));

        campeonatos.add(campeonato1);
        campeonatos.add(campeonato2);

        when(campeonatosRepository.listaCampeonatosPorAtletaId(1L)).thenReturn(campeonatos);

        List<ListaCampeonatoDTO> listaCampeonatos = listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(1L);

        assertNotNull(listaCampeonatos);

        assertEquals(2, listaCampeonatos.size());

        ListaCampeonatoDTO dto1 = listaCampeonatos.get(0);
        assertEquals("Campeonato A", dto1.getNome());
        assertEquals(PosicaoEnum.PRIMEIRO, dto1.getPosicaoPodium());
        assertEquals(LocalDate.of(2023, 1, 15), dto1.getData());

        ListaCampeonatoDTO dto2 = listaCampeonatos.get(1);
        assertEquals("Campeonato B", dto2.getNome());
        assertEquals(PosicaoEnum.SEGUNDO, dto2.getPosicaoPodium());
        assertEquals(LocalDate.of(2023, 2, 20), dto2.getData());
    }

    @Test
    void listaCampeonatosPorAtletaId_DeveRetornarListaVaziaQuandoNenhumCampeonatoEncontrado() {
        when(campeonatosRepository.listaCampeonatosPorAtletaId(1L)).thenReturn(new ArrayList<>());

        List<ListaCampeonatoDTO> listaCampeonatos = listaCampeonatoPorAtletaIdService.listaCampeonatosPorAtletaId(1L);

        assertNotNull(listaCampeonatos);
        assertTrue(listaCampeonatos.isEmpty());
    }
}
