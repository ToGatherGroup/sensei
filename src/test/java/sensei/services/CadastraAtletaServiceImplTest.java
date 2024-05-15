package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.services.atletaService.impl.CadastraAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CadastraAtletaServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @InjectMocks
    private CadastraAtletaServiceImpl cadastraAtletaService;

    @Test
    void saveAtleta_DeveSalvarAtletaCorretamente() {
        // Dados simulados
        AtletaDTO atletaDTO = new AtletaDTO();
        atletaDTO.setNome("João");
        atletaDTO.setNascimento(LocalDate.of(1990, 5, 15));
        atletaDTO.setSexo('M');
        atletaDTO.setPeso(70.5);
        atletaDTO.setAltura(175.0);
        atletaDTO.setFaixa("Faixa Azul");
        atletaDTO.setFoto("foto.jpg");
        atletaDTO.setEmail("joao@example.com");

        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNome(atletaDTO.getNome());
        atletaModel.setNascimento(atletaDTO.getNascimento());
        atletaModel.setSexo(atletaDTO.getSexo());
        atletaModel.setPeso(atletaDTO.getPeso());
        atletaModel.setAltura(atletaDTO.getAltura());
        atletaModel.setFaixa(atletaDTO.getFaixa());
        atletaModel.setFoto(atletaDTO.getFoto());
        atletaModel.setEmail(atletaDTO.getEmail());

        // Configuração do comportamento esperado do repositório
        when(atletaRepository.save(Mockito.any(AtletaModel.class))).thenReturn(atletaModel);

        // Chamada do método a ser testado
        AtletaModel result = cadastraAtletaService.saveAtleta(atletaDTO);

        // Assert
        assertEquals(atletaDTO.getNome(), result.getNome());
        assertEquals(atletaDTO.getNascimento(), result.getNascimento());
        assertEquals(atletaDTO.getSexo(), result.getSexo());
        assertEquals(atletaDTO.getPeso(), result.getPeso());
        assertEquals(atletaDTO.getAltura(), result.getAltura());
        assertEquals(atletaDTO.getFaixa(), result.getFaixa());
        assertEquals(atletaDTO.getFoto(), result.getFoto());
        assertEquals(atletaDTO.getEmail(), result.getEmail());
        // Adicione asserções adicionais conforme necessário
    }
}
