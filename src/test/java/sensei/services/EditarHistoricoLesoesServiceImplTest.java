package sensei.services;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.impl.EditarLesaoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class EditarHistoricoLesoesServiceImplTest {

    @Mock
    private LesaoRepository repository;

    @InjectMocks
    private EditarLesaoServiceImpl service;

    @Test
    void dadoAtualizarDeHistoricoLesao_entaoAtualizeHistorico() {
        // Cria um objeto de modelo de historicoLesoes para ser usado nos testes.
        LesaoModel lesaoModel = new LesaoModel();
        lesaoModel.setId(1L);

        // Configura o comportamento do repository para retornar o historicoLesoesModel quando findById é chamado.
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(lesaoModel));

        // Configura o comportamento do repository para retornar o historicoLesoesModel quando save é chamado.
        Mockito.when(repository.save(any(LesaoModel.class))).thenReturn(lesaoModel);

        // Chama o método a ser testado.
        LesaoModel result = service.updateHistoricoLesao(lesaoModel);

        // Verifica se o resultado não é nulo e se o ID no resultado corresponde ao ID esperado.
        Assertions.assertNotNull(result);
        Assertions.assertEquals(lesaoModel.getId(), result.getId());

        // Verifica se o método findById foi chamado uma vez com qualquer argumento.
        Mockito.verify(repository, Mockito.times(1)).findById(anyLong());

        // Verifica se o método save foi chamado uma vez com qualquer instância de HistoricoLesoesModel.
        Mockito.verify(repository, Mockito.times(1)).save(any(LesaoModel.class));
    }

    @Test
    void dadoAtualizarDeHistoricoLesao_entaoLancarNotFoundException_quandoHistoricoLesaoNaoExistir() {
        // Cria um objeto de modelo de historicoLesoes para ser usado nos testes.
        LesaoModel lesaoModel = new LesaoModel();
        lesaoModel.setId(1L);

        // Configura o comportamento do repository para retornar Optional.empty() quando findById é chamado.
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        // Garante que chamar o método updateHistoricoLesao quando o historicoLesoesModel não existe lançará uma NotFoundException.
        Assertions.assertThrows(NotFoundException.class, () -> service.updateHistoricoLesao(lesaoModel));

        // Verifica se o método findById foi chamado uma vez com qualquer argumento.
        Mockito.verify(repository, Mockito.times(1)).findById(anyLong());

        // Verifica se o método save nunca foi chamado, pois o historicoLesoesModel não existe.
        Mockito.verify(repository, Mockito.never()).save(any(LesaoModel.class));
    }
}
