package sensei.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.togather.sensei.models.CampeonatosDisputadosModel;
import com.togather.sensei.repositories.CampeonatosRepository;
import com.togather.sensei.services.campeonatosService.impl.CadastraCampeonatoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CadastraCampeonatoServiceImplTest {

    @Mock
    private CampeonatosRepository campeonatosRepository;

    @InjectMocks
    private CadastraCampeonatoServiceImpl cadastraCampeonatoService;

    @Test
    void salvaCampeonato_DeveRetornarCampeonatoSalvo() {
        // Objeto de exemplo a ser salvo
        CampeonatosDisputadosModel campeonatoASalvar = new CampeonatosDisputadosModel(/* preencha com os valores necessários */);

        // Simula o retorno do repositório ao salvar o objeto
        when(campeonatosRepository.save(campeonatoASalvar)).thenReturn(campeonatoASalvar);

        // Chama o método a ser testado
        CampeonatosDisputadosModel campeonatoSalvo = cadastraCampeonatoService.salvaCampeonato(campeonatoASalvar);

        // Verifica se o campeonato retornado não é nulo
        assertNotNull(campeonatoSalvo);

        // Você pode adicionar mais asserções aqui conforme necessário para garantir que o campeonato retornado seja o esperado
    }
}
