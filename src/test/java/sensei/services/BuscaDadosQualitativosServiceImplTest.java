package sensei.services;

import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosDTO;
import com.togather.sensei.DTO.dadosqualitativos.DadosQualitativosResponseDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.dadosqualitativosService.impl.BuscarDadosQualitativosImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BuscarDadosQualitativosImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private BuscarDadosQualitativosImpl buscarDadosQualitativosService;

    @Test
    void buscaDadosQualitativos_DeveRetornarDadosCorretos() {
        // Dados de entrada
        long atletaId = 4L;
        LocalDate dataNascimento = LocalDate.of(2008, 1, 1);
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(atletaId);
        atletaModel.setNascimento(dataNascimento);

        // Mock do atletaRepository
        Mockito.when(atletaRepository.getReferenceById(atletaId)).thenReturn(atletaModel);

        // Mock dos resultados dos métodos do avaliacaoRepository
        Mockito.when(avaliacaoRepository.resultadoClassifcacaoCooperPorAtleta(atletaId)).thenReturn("M. Fraco");
        Mockito.when(avaliacaoRepository.resultadoClassificacaoFlexoesPorAtleta(atletaId)).thenReturn("Superior");
        Mockito.when(avaliacaoRepository.resultadoClassificacaoVO2PorAtleta(atletaId)).thenReturn("Excelente");
        Mockito.when(avaliacaoRepository.resultadoClassificacaoAbdominaisPorAtleta(atletaId)).thenReturn("Excelente");
        Mockito.when(avaliacaoRepository.resultadoClassificacaoIMCPorAtleta(atletaId)).thenReturn("Peso normal");
        Mockito.when(avaliacaoRepository.resultadoClassificacaoIMCAdolescentePorAtleta(atletaId)).thenReturn("Peso normal");

        // Chama o método a ser testado
        DadosQualitativosResponseDTO resultado = buscarDadosQualitativosService.buscaDadosQualitativos(atletaId);

        // Asserts
        assertNotNull(resultado);
        List<DadosQualitativosDTO> dados = resultado.getDados();
        assertNotNull(dados);
        assertEquals(5, dados.size());

        // Verifica se os dados esperados estão presentes
        assertTrue(dados.stream().anyMatch(d -> d.getLabel().equals("Cooper") && d.getResult().equals("M. Fraco")));
        assertTrue(dados.stream().anyMatch(d -> d.getLabel().equals("Classificação Flexões") && d.getResult().equals("Superior")));
        assertTrue(dados.stream().anyMatch(d -> d.getLabel().equals("Resultado VO2") && d.getResult().equals("Excelente")));
        assertTrue(dados.stream().anyMatch(d -> d.getLabel().equals("Classificação Abdominal") && d.getResult().equals("Excelente")));
        assertTrue(dados.stream().anyMatch(d -> d.getLabel().equals("Classificação IMC") && d.getResult().equals("Peso normal")));
    }

    @Test
    void calcularIdade_DeveCalcularIdadeCorretamente() {
        // Dados de entrada
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);

        // Chama o método a ser testado
        int idade = buscarDadosQualitativosService.calcularIdade(dataNascimento);

        // Assert
        assertEquals(24, idade);
    }
}
