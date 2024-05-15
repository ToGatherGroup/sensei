package sensei.services;

import com.togather.sensei.models.AvaliacaoModel;
import com.togather.sensei.repositories.AvaliacaoRepository;
import com.togather.sensei.services.avaliacaoService.impl.AvaliacaoPostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class AvaliacaoPostServiceImplTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoPostServiceImpl avaliacaoPostService;

    @Test
    void saveAvaliacao_DeveChamarSaveDoRepositorio() {
        // Dado um modelo de avaliação
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();

        // Chamada do método a ser testado
        avaliacaoPostService.saveAvaliacao(avaliacaoModel);

        // Verificação se o método save do repositório foi chamado com o modelo de avaliação correto
        verify(avaliacaoRepository).save(avaliacaoModel);
    }
}

