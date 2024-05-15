package sensei.services;

import com.togather.sensei.DTO.avaliacaopostural.AvaliacaoPosturalDTO;
import com.togather.sensei.enums.PosicaoFotoEnum;
import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.models.AvaliacaoPosturalPK;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.impl.AvaliacoesPosturaisByPosicaoServiceImpl;
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
class AvaliacoesPosturaisByPosicaoServiceImplTest {

    @Mock
    private AvaliacaoPosturalRepository avaliacaoPosturalRepository;

    @InjectMocks
    private AvaliacoesPosturaisByPosicaoServiceImpl avaliacoesPosturaisByPosicaoService;

    @Test
    void buscarAvaliacoesPosturalByData_DeveRetornarListaDeAvaliacoesCorretamente() {
        // Dado um ID de atleta e uma data
        Long atletaId = 1L;
        LocalDate data = LocalDate.now();

        // Lista simulada de avaliações posturais
        List<AvaliacaoPosturalModel> listaAvaliacoesPosturais = new ArrayList<>();

        AvaliacaoPosturalPK avaliacaoPosturalPK = new AvaliacaoPosturalPK();
        avaliacaoPosturalPK.setPosicao(PosicaoFotoEnum.COSTAS);

        AvaliacaoPosturalModel avaliacao1 = new AvaliacaoPosturalModel();
        avaliacao1.setFoto("foto1.jpg");
        avaliacao1.setAvaliacaoPosturalPK(avaliacaoPosturalPK);
        listaAvaliacoesPosturais.add(avaliacao1);
        // Adicione mais avaliações posturais conforme necessário para o teste

        // Configuração do comportamento esperado do repositório
        when(avaliacaoPosturalRepository.buscarAvaliacoesPosturaisByData(atletaId, data)).thenReturn(listaAvaliacoesPosturais);

        // Chamada do método a ser testado
        List<AvaliacaoPosturalDTO> result = avaliacoesPosturaisByPosicaoService.buscarAvaliacoesPosturalByData(atletaId, data);

        // Verificação se a lista retornada contém as avaliações posturais simuladas de forma correta
        assertEquals(listaAvaliacoesPosturais.size(), result.size());
        // Verifique se os detalhes das avaliações posturais simuladas correspondem aos detalhes retornados
        // (por exemplo, verificar se a foto e a posição são iguais)
        assertEquals(listaAvaliacoesPosturais.get(0).getFoto(), result.get(0).getFoto());
        assertEquals(PosicaoFotoEnum.COSTAS, result.get(0).getPosicao());
        // Adicione mais verificações conforme necessário para os detalhes das avaliações posturais
    }
}

