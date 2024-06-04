//package com.togather.sensei.controllers.avaliacaoController;
//
//import com.togather.sensei.services.avaliacaoService.DeletarAvaliacaoMesmaDataService;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.web.client.HttpClientErrorException;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class ExcluirAvaliacaoMesmaDataControllerTest {
//
////    @Mock
//    private DeletarAvaliacaoMesmaDataService deletarAvaliacaoMesmaDataService;
//
//    @InjectMocks
//    private ExcluirAvaliacaoMesmaDataController excluirAvaliacaoMesmaDataController;
//
//    private LocalDate data;
//    @BeforeEach
//    private void setUp(){
//        LocalDate data = LocalDate.now();
//    }
//
//    @Test
//    void dadoDataValida_entaoRetorneNoContent() {
//
//        Mockito.doNothing().when(deletarAvaliacaoMesmaDataService).deletaAvaliacaoMesmaData(data);
//
//        ResponseEntity<Void> response = excluirAvaliacaoMesmaDataController.apagaAvaliacaoMesmaData(data);
//
//
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//    }
//
//    @Test
//    void dadoDataInvalida_entaoRetorneHttpClientErrorException(){
//        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND, "Not Found");
//        Mockito.doThrow(exception).when(deletarAvaliacaoMesmaDataService).deletaAvaliacaoMesmaData(data);
//
//        HttpClientErrorException thrown = assertThrows(HttpClientErrorException.class, () -> deletarAvaliacaoMesmaDataService.deletaAvaliacaoMesmaData(data));
//
//        assertEquals(HttpStatus.NOT_FOUND, thrown.getStatusCode());
//    }
//}