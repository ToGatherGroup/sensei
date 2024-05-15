package sensei.services;

import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.PresencaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.PresencaRepository;
import com.togather.sensei.services.presencaService.impl.ChamadaDeAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChamadaDeAtletaServiceImplTest {

    @Mock
    private PresencaRepository presencaRepository;

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private ChamadaDeAtletaServiceImpl chamadaDeAtletaService;

    @Test
    void chamadaDeAtleta_DeveSalvarPresencasParaAtletas() {
        // Simula os IDs dos atletas a serem chamados
        List<Long> idAtletaList = Arrays.asList(1L, 2L, 3L);

        // Simula a existência de atletas correspondentes aos IDs
        when(atletaRepository.findById(1L)).thenReturn(Optional.of(new AtletaModel()));
        when(atletaRepository.findById(2L)).thenReturn(Optional.of(new AtletaModel()));
        when(atletaRepository.findById(3L)).thenReturn(Optional.of(new AtletaModel()));

        // Chame o método a ser testado
        chamadaDeAtletaService.chamadaDeAtleta(idAtletaList);

        // Verifique se o método save do PresencaRepository foi chamado para cada atleta na lista
        verify(presencaRepository, times(3)).save(any(PresencaModel.class));
    }
}
