package sensei.controllers;

import com.togather.sensei.controllers.lesaoController.CadastraLesaoController;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.services.lesaoService.CadastraLesaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class CadastraLesaoControllerTest {

    @Mock
    private CadastraLesaoService cadastraLesaoService;

    @InjectMocks
    private CadastraLesaoController cadastraLesaoController;

    @Test
    void cadastraLesao_DeveRetornarLesaoModel() {
        // Criação de um modelo de lesão de entrada
        LesaoModel inputLesaoModel = new LesaoModel();

        // Configuração do comportamento esperado do serviço
        Mockito.when(cadastraLesaoService.savehistoricoLesoes(inputLesaoModel)).thenReturn(inputLesaoModel);

        // Chama o método a ser testado
        LesaoModel resultLesaoModel = cadastraLesaoController.cadastraLesao(inputLesaoModel);

        // Assert
        // Verifica se o resultado é o esperado
        assertEquals(inputLesaoModel, resultLesaoModel);
    }
}

