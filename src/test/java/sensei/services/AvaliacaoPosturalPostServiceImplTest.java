package sensei.services;

import com.togather.sensei.models.AvaliacaoPosturalModel;
import com.togather.sensei.repositories.AvaliacaoPosturalRepository;
import com.togather.sensei.services.avaliacaoposturalService.impl.AvaliacaoPosturalPostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class AvaliacaoPosturalPostServiceImplTest {

    @Mock
    private AvaliacaoPosturalRepository avaliacaoPosturalRepository;

    @InjectMocks
    private AvaliacaoPosturalPostServiceImpl avaliacaoPosturalPostService;

    @Test
    void saveAvaliacaoPostural_DeveChamarSaveDoRepositorio() {
        // Dado um modelo de avaliação postural
        AvaliacaoPosturalModel avaliacaoPosturalModel = new AvaliacaoPosturalModel();

        // Chamada do método a ser testado
        avaliacaoPosturalPostService.saveAvaliacaoPostural(avaliacaoPosturalModel);

        // Verificação se o método save do repositório foi chamado com o modelo de avaliação postural correto
        verify(avaliacaoPosturalRepository).save(avaliacaoPosturalModel);
    }
}
