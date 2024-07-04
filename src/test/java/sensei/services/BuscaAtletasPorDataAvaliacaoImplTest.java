package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaIdNomeDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.models.AvaliacaoModelId;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaPorDataAvaliacaoServiceImpl;
import com.togather.sensei.services.atletaService.impl.BuscaListaDeAusentesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BuscaAtletasPorDataAvaliacaoImplTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private BuscaAtletaPorDataAvaliacaoServiceImpl buscaAtletaPorDataAvaliacaoService;

    @Test
    void getAtletasPorData_DeveRetornarListaDeAtletasNaData() {
        LocalDate data = LocalDate.now();
        AtletaModel atleta1 = new AtletaModel();
        atleta1.setId(1L);
        atleta1.setNome("Wilson");
        AtletaModel atleta2 = new AtletaModel();
        atleta2.setId(2L);
        atleta2.setNome("Alex");

        AvaliacaoModelId avaliacaoId1 = new AvaliacaoModelId(atleta1,data);
        AvaliacaoModelId avaliacaoId2 = new AvaliacaoModelId(atleta2,data);

        AvaliacaoModel avaliacao1 = new AvaliacaoModel();
        avaliacao1.setAvaliacaoModelId(avaliacaoId1);
        AvaliacaoModel avaliacao2 = new AvaliacaoModel();
        avaliacao2.setAvaliacaoModelId(avaliacaoId2);



        List<AvaliacaoModel> avaliacoesNaData = new ArrayList<>();
        avaliacoesNaData.add(avaliacao1);
        avaliacoesNaData.add(avaliacao2);

        when(avaliacaoRepository.buscaAvaliacaoMesmaData(data)).thenReturn(avaliacoesNaData);

        List<AtletaIdNomeDTO> result = buscaAtletaPorDataAvaliacaoService.findAtletasbyData(data);

        assertEquals(avaliacoesNaData.size(), result.size());
        assertEquals("Wilson", result.get(0).getNome());
        assertEquals("Alex", result.get(1).getNome());

    }
}

