package sensei.services;

import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacaoIncompletaServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class AvaliacaoIncompletaServiceImplTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoIncompletaServiceImpl avaliacaoService;

//    @Test
//    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaDeAvaliacoesDTO() {
//        // Criação de uma lista de AvaliacaoModel esperada
//        List<AvaliacaoModel> avaliacoesIncompletas = new ArrayList<>();
//        AvaliacaoModelId avaliacaoModelId = new AvaliacaoModelId();
//        AtletaModel atletaModel = new AtletaModel();
//        atletaModel.setId(1L);
//        atletaModel.setNome("Atleta 1");
//        avaliacaoModelId.setData(LocalDate.parse("2023-01-01"));
//        avaliacaoModelId.setAtletaModel(atletaModel);
//
//        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
//        avaliacaoModel.setAvaliacaoModelId(avaliacaoModelId);
//        avaliacaoModel.setPeso(70.0);
//        avaliacaoModel.setAltura(1.75);
//        avaliacaoModel.setPrancha(Duration.ofDays(60));
//        avaliacaoModel.setFlexoes(20);
//        avaliacaoModel.setAbdominais(30);
//        avaliacaoModel.setBurpees(10);
//        avaliacaoModel.setCooper(2000);
//        avaliacaoModel.setRmTerra(100);
//        avaliacaoModel.setForcaIsometricaMaos(Duration.ofDays(50));
//        avaliacaoModel.setTesteDeLunge(15.0);
//        avaliacaoModel.setImpulsaoVertical(40.0);
//
//        avaliacoesIncompletas.add(avaliacaoModel);
//
//        // Configuração do comportamento esperado do repositório
//        Mockito.when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(avaliacoesIncompletas);
//
//        // Chama o método a ser testado
//        List<AvaliacaoIncompletaDTO> result = avaliacaoService.buscaAvaliacoesIncompletas();
//
//        // Verifica se o resultado é o esperado
//        assertEquals(1, result.size());
//        AvaliacaoIncompletaDTO dto = result.get(0);
//        assertEquals(LocalDate.parse("2023-01-01"), dto.getDataAvaliacao());
//        assertEquals(1L, dto.getIdAtleta());
//        assertEquals("Atleta 1", dto.getNomeAtleta());
//        assertEquals(70.0, dto.getPeso());
//        assertEquals(1.75, dto.getAltura());
//        assertEquals(Duration.ofDays(60), dto.getPrancha());
//        assertEquals(20, dto.getFlexoes());
//        assertEquals(30, dto.getAbdominais());
//        assertEquals(10, dto.getBurpees());
//        assertEquals(2000, dto.getCooper());
//        assertEquals(100, dto.getRmTerra());
//        assertEquals(Duration.ofDays(50), dto.getForcaIsometricaMaos());
//        assertEquals(15, dto.getTesteDeLunge());
//        assertEquals(40, dto.getImpulsaoVertical());
//    }
//
//    @Test
//    void dadoBuscaAvaliacoesIncompletas_entaoRetorneListaVazia() {
//        // Criação de uma lista vazia de AvaliacaoModel
//        List<AvaliacaoModel> avaliacoesIncompletas = new ArrayList<>();
//
//        // Configuração do comportamento esperado do repositório
//        Mockito.when(avaliacaoRepository.getAvaliacoesIncompletas()).thenReturn(avaliacoesIncompletas);
//
//        // Chama o método a ser testado
//        List<AvaliacaoIncompletaDTO> result = avaliacaoService.buscaAvaliacoesIncompletas();
//
//        // Verifica se o resultado é o esperado
//        assertEquals(0, result.size());
//    }

  //  @Test
//    void dadoErroNoRepositorio_entaoLancaExcecao() {
//        // Configuração do comportamento esperado do repositório para lançar uma exceção
//        Mockito.when(avaliacaoRepository.getAvaliacoesIncompletas()).thenThrow(new RuntimeException("Erro no repositório"));
//
//        // Verifica se o método lança a exceção esperada
//        RuntimeException thrown = org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> avaliacaoService.buscaAvaliacoesIncompletas());
//
//        // Verifica a mensagem da exceção
//        assertEquals("Erro no repositório", thrown.getMessage());
//    }
}

