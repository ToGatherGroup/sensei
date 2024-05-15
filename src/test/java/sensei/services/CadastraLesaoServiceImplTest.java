package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.impl.CadastraLesaoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CadastraLesaoServiceImplTest {

    @Mock
    private LesaoRepository lesaoRepository;

    @InjectMocks
    private CadastraLesaoServiceImpl cadastraLesaoService;

    @Test
    void savehistoricoLesoes_DeveRetornarLesaoModel() {
        // Simula o modelo de lesão a ser salvo
        LesaoModel lesaoModel = new LesaoModel(); // Você pode configurar o modelo conforme necessário

        // Defina o comportamento esperado para o método save do repositório mockado
        when(lesaoRepository.save(lesaoModel)).thenReturn(lesaoModel);

        // Chame o método a ser testado
        LesaoModel resultado = cadastraLesaoService.savehistoricoLesoes(lesaoModel);

        // Verifique se o resultado retornado não é nulo
        assertNotNull(resultado);

        // Adicione mais asserções conforme necessário para verificar se o resultado é o esperado
    }
}

