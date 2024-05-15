package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.impl.BuscaMedalhaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BuscaMedalhaServiceImplTest {

    @Mock
    private CampeonatosRepository campeonatosRepository;

    @InjectMocks
    private BuscaMedalhaServiceImpl buscaMedalhaService;

    @Test
    void buscaMedalhas_DeveRetornarListaDeMedalhasCorretamente() {
        // Simula a lista de campeonatos retornada pelo repositório
        List<Object[]> campeonatos = new ArrayList<>();
        campeonatos.add(new Object[]{1, 3L}); // Por exemplo, 3 medalhas para a posição 1
        campeonatos.add(new Object[]{2, 5L}); // Por exemplo, 5 medalhas para a posição 2

        // Define o comportamento esperado para o método do repositório mockado
        when(campeonatosRepository.listaMedalhas(1L)).thenReturn(campeonatos);

        // Chama o método a ser testado
        List<MedalhaDTO> medalhas = buscaMedalhaService.buscaMedalhas(1L);

        // Verifica se a lista de medalhas não é nula
        assertNotNull(medalhas);

        // Verifica se a lista tem o tamanho esperado (igual ao número de campeonatos)
        assertEquals(2, medalhas.size());

        // Verifica se as medalhas foram criadas corretamente
        assertEquals("Medalha de ouro", medalhas.get(0).getPosicao());
        assertEquals(3, medalhas.get(0).getQuantidade());

        assertEquals("Medalha de prata", medalhas.get(1).getPosicao());
        assertEquals(5, medalhas.get(1).getQuantidade());
    }
}

