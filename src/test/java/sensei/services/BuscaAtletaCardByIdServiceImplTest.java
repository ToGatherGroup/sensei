package sensei.services;

import com.togather.sensei.DTO.atleta.AtletaCardDTO;
import com.togather.sensei.DTO.campeonato.MedalhaDTO;
import com.togather.sensei.models.AtletaModel;
import com.togather.sensei.repositories.AtletaRepository;
import com.togather.sensei.repositories.CategoriaRepository;
import com.togather.sensei.services.atletaService.impl.BuscaAtletaCardByIdServiceImpl;
import com.togather.sensei.services.campeonatosService.BuscaMedalhaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BuscaAtletaCardByIdServiceImplTest {

    @Mock
    private AtletaRepository atletaRepository;

    @Mock
    private BuscaMedalhaService buscaMedalhaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private BuscaAtletaCardByIdServiceImpl buscaAtletaCardByIdService;

    @Test
    void findAtletaCardById_DeveRetornarAtletaCardDTO() {
        // Dados de entrada
        Long id = 1L;
        LocalDate nascimento = LocalDate.of(1990, 10, 15);
        AtletaModel atletaModel = new AtletaModel();
        atletaModel.setId(id);
        atletaModel.setNome("João");
        atletaModel.setNascimento(nascimento);
        // Adicione lógica para configurar outros dados do atleta

        // Mock do comportamento esperado do repositório
        when(atletaRepository.findById(id)).thenReturn(Optional.of(atletaModel));

        // Mock do comportamento esperado do serviço de busca de medalhas
        List<MedalhaDTO> medalhaDTOList = new ArrayList<>();
        // Adicione lógica para configurar o comportamento do serviço de busca de medalhas conforme necessário
        when(buscaMedalhaService.buscaMedalhas(id)).thenReturn(medalhaDTOList);



        // Mock do comportamento esperado do repositório de categorias
        String categoria = "Categoria Teste";
        // Adicione lógica para configurar o comportamento do repositório de categorias conforme necessário
        when(categoriaRepository.gerarCategoria(any(Integer.class))).thenReturn(categoria);


        // Mock do comportamento esperado do mapeador
        AtletaCardDTO atletaCardDTO = new AtletaCardDTO();
        // Adicione lógica para configurar o comportamento do mapeador conforme necessário
        when(mapper.map(atletaModel, AtletaCardDTO.class)).thenReturn(atletaCardDTO);

        // Chama o método a ser testado
        AtletaCardDTO result = buscaAtletaCardByIdService.findAtletaCardById(id);

        // Assert
        // Adicione asserções para verificar se o resultado está correto
        assertEquals(calculaIdade(nascimento), result.getIdade());
        // Adicione asserções para verificar outros atributos do DTO
    }

    private int calculaIdade(LocalDate nascimento){
        Period period = Period.between(nascimento, LocalDate.now());
        return period.getYears();
    }
}
