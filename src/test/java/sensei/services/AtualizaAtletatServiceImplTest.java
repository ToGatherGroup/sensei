package sensei.services;

import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.AtualizaAtletatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class AtualizaAtletatServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private AtualizaAtletatServiceImpl atualizaAtletatService;

    @Test
    void updateAtleta_DeveAtualizarAtleta() {
        // Dados de entrada
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNome("João");
        // Adicionar lógica para configurar outros dados do atleta

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findById(1L)).thenReturn(Optional.of(atletaModel));
        Mockito.when(atletaRepository.save(atletaModel)).thenReturn(atletaModel);

        // Chama o método a ser testado
        AtletaModel result = atualizaAtletatService.updateAtleta(atletaModel);

        // Assert
        // Verifica se o atleta foi atualizado corretamente
        assertEquals(atletaModel, result);
    }

    @Test
    void updateAtleta_DeveLancarNotFoundExceptionQuandoAtletaNaoExistir() {
        // Dados de entrada
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNome("João");
        // Adicionar lógica para configurar outros dados do atleta

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findById(1L)).thenReturn(Optional.empty());

        // Verifica se o método lança a exceção esperada
        NotFoundException exception = assertThrows(NotFoundException.class, () -> atualizaAtletatService.updateAtleta(atletaModel));

        // Assert
        // Verifica se a exceção contém a mensagem correta
        assertEquals("Atleta informado não encontrado.", exception.getMessage());
    }
}
