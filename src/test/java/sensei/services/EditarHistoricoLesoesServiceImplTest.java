package sensei.services;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.HistoricoLesoesModel;
import com.togather.sensei.repositories.HistoricoLesoesRepository;
import com.togather.sensei.services.impl.EditarHistoricoLesoesServiceImpl;
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
    private HistoricoLesoesRepository repository;

    @InjectMocks
    private EditarHistoricoLesoesServiceImpl service;

    @Test
    void dadoAtualizarDeHistoricoLesao_entaoAtualizeHistorico() {
        // Cria um objeto de modelo de historicoLesoes para ser usado nos testes.
        HistoricoLesoesModel historicoLesoesModel = new HistoricoLesoesModel();
        historicoLesoesModel.setId(1L);

        // Configura o comportamento do repository para retornar o historicoLesoesModel quando findById é chamado.
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(historicoLesoesModel));

        // Configura o comportamento do repository para retornar o historicoLesoesModel quando save é chamado.
        Mockito.when(repository.save(any(HistoricoLesoesModel.class))).thenReturn(historicoLesoesModel);

        // Chama o método a ser testado.
        HistoricoLesoesModel result = service.updateHistoricoLesao(historicoLesoesModel);

        // Verifica se o resultado não é nulo e se o ID no resultado corresponde ao ID esperado.
        Assertions.assertNotNull(result);
        Assertions.assertEquals(historicoLesoesModel.getId(), result.getId());

        // Verifica se o método findById foi chamado uma vez com qualquer argumento.
        Mockito.verify(repository, Mockito.times(1)).findById(anyLong());

        // Verifica se o método save foi chamado uma vez com qualquer instância de HistoricoLesoesModel.
        Mockito.verify(repository, Mockito.times(1)).save(any(HistoricoLesoesModel.class));
    }

    @Test
    void dadoAtualizarDeHistoricoLesao_entaoLancarNotFoundException_quandoHistoricoLesaoNaoExistir() {
        // Cria um objeto de modelo de historicoLesoes para ser usado nos testes.
        HistoricoLesoesModel historicoLesoesModel = new HistoricoLesoesModel();
        historicoLesoesModel.setId(1L);

        // Configura o comportamento do repository para retornar Optional.empty() quando findById é chamado.
        Mockito.when(repository.findById(anyLong())).thenReturn(Optional.empty());

        // Garante que chamar o método updateHistoricoLesao quando o historicoLesoesModel não existe lançará uma NotFoundException.
        Assertions.assertThrows(NotFoundException.class, () -> service.updateHistoricoLesao(historicoLesoesModel));

        // Verifica se o método findById foi chamado uma vez com qualquer argumento.
        Mockito.verify(repository, Mockito.times(1)).findById(anyLong());

        // Verifica se o método save nunca foi chamado, pois o historicoLesoesModel não existe.
        Mockito.verify(repository, Mockito.never()).save(any(HistoricoLesoesModel.class));
    }
}
