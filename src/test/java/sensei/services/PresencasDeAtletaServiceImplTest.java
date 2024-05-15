package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import com.togather.sensei.DTO.presenca.PresencaAtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.presencaService.impl.PresencasDeAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PresencasDeAtletaServiceImplTest {

    @Mock
    private PresencaRepository presencaRepository;

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private PresencasDeAtletaServiceImpl presencasDeAtletaService;

    @Test
    void buscarPresencasPorAtleta_DeveRetornarPresencaAtletaDTO() {
        // Simula o ID do atleta
        Long idAtleta = 1L;
        // Simula as datas de início e fim
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fim = LocalDate.of(2024, 12, 31);

        // Simula um AtletaModel existente
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(idAtleta);
        atletaModel.setNome("Teste Atleta");
        Optional<AtletaModel> optionalAtletaModel = Optional.of(atletaModel);
        when(atletaRepository.findById(idAtleta)).thenReturn(optionalAtletaModel);

        // Simula o total de presença e de dias
        Long totalPresenca = 50L;
        Long totalDias = 100L;
        when(presencaRepository.buscaPresenca(idAtleta, inicio, fim)).thenReturn(totalPresenca);
        when(presencaRepository.buscaTotalDias(inicio, fim)).thenReturn(totalDias);

        // Chame o método a ser testado
        PresencaAtletaDTO presencaAtletaDTO = presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta, inicio, fim);

        // Verifique se o DTO retornado não é nulo
        assertNotNull(presencaAtletaDTO);
        // Verifique se os valores do DTO estão corretos
        assertEquals(idAtleta, presencaAtletaDTO.getId_atleta());
        assertEquals("Teste Atleta", presencaAtletaDTO.getNome());
        assertEquals(totalPresenca, presencaAtletaDTO.getTotalPresenca());
        assertEquals(totalDias - totalPresenca, presencaAtletaDTO.getTotalAusencia());
        assertEquals("50%", presencaAtletaDTO.getPorcentagemPresenca());
    }

    @Test
    void buscarPresencasPorAtleta_DeveLancarNotFoundException_QuandoAtletaNaoExistir() {
        // Simula o ID do atleta
        Long idAtleta = 1L;
        // Simula as datas de início e fim
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fim = LocalDate.of(2024, 12, 31);

        // Simula um AtletaModel não existente
        when(atletaRepository.findById(idAtleta)).thenReturn(Optional.empty());

        // Verifique se uma exceção é lançada quando o atleta não é encontrado
        assertThrows(NotFoundException.class, () -> presencasDeAtletaService.buscarPresencasPorAtleta(idAtleta, inicio, fim));
    }
}

