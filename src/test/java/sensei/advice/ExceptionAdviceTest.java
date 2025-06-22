package sensei.advice;

import com.togather.sensei.advice.ExceptionAdvice;
import com.togather.sensei.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionAdviceTest {
    private ExceptionAdvice advice;

    @BeforeEach
    void setUp() {
        advice = new ExceptionAdvice();
    }

    @Test
    void tratarExcecaoNotFoundException_DeveRetornarNotFound() {
        NotFoundException ex = new NotFoundException("Não encontrado");
        ResponseEntity<Object> response = advice.tratarExcecaoNotFoundException(ex);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Map<?, ?> body = (Map<?, ?>) response.getBody();
        assertEquals(HttpStatus.NOT_FOUND.getReasonPhrase(), body.get(ExceptionAdvice.STATUS_CODE));
        assertEquals("Não encontrado", body.get(ExceptionAdvice.MESSAGE));
    }

    @Test
    void tratarExcecaoHttpClientErrorException_DeveRetornarUnauthorized() {
        HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Não autorizado");
        ResponseEntity<Object> response = advice.tratarExcecaoHttpClientErrorException(ex);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        Map<?, ?> body = (Map<?, ?>) response.getBody();
        assertEquals(HttpStatus.UNAUTHORIZED.getReasonPhrase(), body.get(ExceptionAdvice.STATUS_CODE));
        assertEquals(ex.getMessage(), body.get(ExceptionAdvice.MESSAGE));
    }

    @Test
    void tratarExcecaoIllegalArgumentException_DeveRetornarBadRequest() {
        IllegalArgumentException ex = new IllegalArgumentException("Requisição inválida");
        ResponseEntity<Object> response = advice.tratarExcecaoIllegalArgumentException(ex);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Map<?, ?> body = (Map<?, ?>) response.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), body.get(ExceptionAdvice.STATUS_CODE));
        assertEquals("Requisição inválida", body.get(ExceptionAdvice.MESSAGE));
    }
}

