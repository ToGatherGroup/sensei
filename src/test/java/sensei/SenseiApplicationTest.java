package sensei;

import com.togather.sensei.SenseiApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenseiApplicationTest {

    @Test
    void main_DeveExecutarSemExcecao() {
        // O teste apenas garante que o método main executa sem lançar exceções.
        assertDoesNotThrow(() -> SenseiApplication.main(new String[]{}));
    }
}

