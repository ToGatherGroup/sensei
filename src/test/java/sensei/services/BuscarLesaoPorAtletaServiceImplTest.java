package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.togather.sensei.DTO.lesao.LesaoDTO;
import com.togather.sensei.models.LesaoModel;
import com.togather.sensei.repositories.LesaoRepository;
import com.togather.sensei.services.lesaoService.impl.BuscarLesaoPorAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BuscarLesaoPorAtletaServiceImplTest {

    @Mock
    private LesaoRepository lesaoRepository;

    @InjectMocks
    private BuscarLesaoPorAtletaServiceImpl buscarLesaoPorAtletaService;

    @Test
    void buscaHistoricoLesoes_DeveRetornarListaDeLesoes() {
        // Simula o retorno do repositório ao buscar histórico de lesões por ID de atleta
        long atletaId = 1L; // ID do atleta de exemplo
        List<LesaoModel> lesaoModels = new ArrayList<>(); // Lista de lesões de exemplo
        // Adicione algumas lesões à lista de exemplo, se necessário

        // Defina o comportamento esperado para o método do repositório mockado
        when(lesaoRepository.buscarHistoricoDeLesoesPorAtletaId(atletaId)).thenReturn(lesaoModels);

        // Chame o método a ser testado
        List<LesaoDTO> resultado = buscarLesaoPorAtletaService.buscaHistoricoLesoes(atletaId);

        // Verifique se o resultado retornado não é nulo
        assertNotNull(resultado);

        // Adicione mais asserções conforme necessário para verificar se o resultado é o esperado
    }
}

