package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.exceptions.NotFoundException;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaByIdServiceImpl;
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
class BuscaAtletaByIdServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private BuscaAtletaByIdServiceImpl buscaAtletaByIdService;

    @Test
    void findAtletaById_DeveRetornarAtletaDTO() {
        // Dados de entrada
        Long id = 1L;
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(id);
        atletaModel.setNome("João");
        // Adicionar lógica para configurar outros dados do atleta

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findById(id)).thenReturn(Optional.of(atletaModel));

        // Chama o método a ser testado
        AtletaModel result = buscaAtletaByIdService.findAtletaById(id);

        // Assert
        // Verifica se o DTO do atleta retornado possui os mesmos valores que o atleta model configurado
        assertEquals(atletaModel.getNome(), result.getNome());
        // Adicionar lógica para verificar outros atributos do DTO
    }

    @Test
    void findAtletaById_DeveLancarNotFoundExceptionQuandoAtletaNaoExistir() {
        // Dados de entrada
        Long id = 1L;

        // Configuração do comportamento esperado do repositório
        Mockito.when(atletaRepository.findById(id)).thenReturn(Optional.empty());

        // Verifica se o método lança a exceção esperada
        NotFoundException exception = assertThrows(NotFoundException.class, () -> buscaAtletaByIdService.findAtletaById(id));

        // Assert
        // Verifica se a exceção contém a mensagem correta
        assertEquals("Atleta não encontrado.", exception.getMessage());
    }
}
