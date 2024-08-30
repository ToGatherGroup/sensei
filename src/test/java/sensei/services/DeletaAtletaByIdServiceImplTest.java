//package sensei.services;
//
//import com.togather.sensei.exceptions.NotFoundException;
//import com.togather.sensei.models.AtletaModel;
//import com.togather.sensei.repositories.AtletaRepository;
//import com.togather.sensei.services.atletaService.impl.DeletaAtletaByIdServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//class DeletaAtletaByIdServiceImplTest {
//
//    @Mock
//    private AtletaRepository atletaRepository;
//
//    @InjectMocks
//    private DeletaAtletaByIdServiceImpl deletaAtletaByIdService;
//
//    @Test
//    void deleteAtletaById_DeveDeletarAtletaCorretamente() {
//        // Dado um ID de atleta existente
//        long atletaId = 1L;
//        AtletaModel atletaModel = new AtletaModel();
//        atletaModel.setId(atletaId);
//
//        // Configuração do comportamento esperado do repositório
//        when(atletaRepository.findById(atletaId)).thenReturn(Optional.of(atletaModel));
//
//        // Chamada do método a ser testado
//        deletaAtletaByIdService.deleteAtletaById(atletaId);
//
//        // Verificação se o método delete do repositório foi chamado com o atleta correto
//        verify(atletaRepository).delete(atletaModel);
//    }
//
//    @Test
//    void deleteAtletaById_DeveLancarNotFoundException_QuandoAtletaNaoExistir() {
//        // Dado um ID de atleta inexistente
//        long atletaId = 1L;
//
//        // Configuração do comportamento esperado do repositório
//        when(atletaRepository.findById(atletaId)).thenReturn(Optional.empty());
//
//        // Verificação se uma exceção é lançada quando tentamos deletar um atleta inexistente
//        assertThrows(NotFoundException.class, () -> deletaAtletaByIdService.deleteAtletaById(atletaId));
//    }
//}
