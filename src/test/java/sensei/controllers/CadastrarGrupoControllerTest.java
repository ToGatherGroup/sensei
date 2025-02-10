package sensei.controllers;

import com.togather.sensei.controllers.grupoController.CadastraGrupoController;
import com.togather.sensei.models.classificacoes.GrupoModel;
import com.togather.sensei.services.grupoService.CadastraGrupoSerivce;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class CadastrarGrupoControllerTest {

    @Mock
    private CadastraGrupoSerivce cadastraGrupoSerivce;

    @InjectMocks
    private CadastraGrupoController cadastraGrupoController;

    @Test
    void cadastrarGrupo() {
        // Criacao de um modelo de entrada
        GrupoModel grupoModel = new GrupoModel();

        // Configuração do comportamento esperado do serviço
        Mockito.when(cadastraGrupoSerivce.cadastrarGrupo(Mockito.anyString())).thenReturn(grupoModel);

        // Chama o método a ser testado
        GrupoModel returnedGrupoModel = cadastraGrupoController.cadastrarGrupo(Mockito.anyString()).getBody();

        //Assert
        // Verifica se o resultado é o esperado
        assertEquals(grupoModel, returnedGrupoModel);
    }
}
