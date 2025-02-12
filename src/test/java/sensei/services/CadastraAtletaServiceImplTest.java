package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.GrupoRepository;
import com.togather.sensei.services.atletaService.impl.CadastraAtletaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CadastraAtletaServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private GrupoRepository grupoRepository;

    @InjectMocks
    private CadastraAtletaServiceImpl cadastraAtletaService;

    @Test
    void saveAtleta_DeveSalvarAtletaCorretamente() {
        // Dados simulados

        GrupoModel grupo = new GrupoModel(1L,"grupoTest",true);
        AtletaDTO atletaDTO = new AtletaDTO();
        atletaDTO.setNome("João");
        atletaDTO.setNascimento(LocalDate.of(1990, 5, 15));
        atletaDTO.setSexo('M');
        atletaDTO.setFaixa("Faixa Azul");
        atletaDTO.setFoto("foto.jpg");
        atletaDTO.setEmail("joao@example.com");
        atletaDTO.setGrupo(grupo);

        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(1L);
        atletaModel.setNome(atletaDTO.getNome());
        atletaModel.setNascimento(atletaDTO.getNascimento());
        atletaModel.setSexo(atletaDTO.getSexo());
        atletaModel.setFaixa(atletaDTO.getFaixa());
        atletaModel.setFoto(atletaDTO.getFoto());
        atletaModel.setEmail(atletaDTO.getEmail());
        atletaModel.setGrupo(atletaDTO.getGrupo());

        // Configuração do comportamento esperado do repositório
        when(atletaRepository.save(Mockito.any(AtletaModel.class))).thenReturn(atletaModel);
        when(grupoRepository.findById(any())).thenReturn(Optional.of(grupo));

        // Chamada do método a ser testado
        AtletaModel result = cadastraAtletaService.saveAtleta(atletaDTO);

        // Assert
        assertEquals(atletaDTO.getNome(), result.getNome());
        assertEquals(atletaDTO.getNascimento(), result.getNascimento());
        assertEquals(atletaDTO.getSexo(), result.getSexo());
        assertEquals(atletaDTO.getFaixa(), result.getFaixa());
        assertEquals(atletaDTO.getFoto(), result.getFoto());
        assertEquals(atletaDTO.getEmail(), result.getEmail());
        assertEquals(atletaDTO.getGrupo(), result.getGrupo());
        // Adicione asserções adicionais conforme necessário
    }
}
