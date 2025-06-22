package sensei.helper;

import com.togather.sensei.helper.NullBeanUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class NullBeanUtilsTest {
    private NullBeanUtils nullBeanUtils;

    @BeforeEach
    void setUp() {
        nullBeanUtils = new NullBeanUtils();
    }

    public static class BeanTeste implements java.io.Serializable {
        private String chave;
        public BeanTeste() {}
        public String getChave() { return chave; }
        public void setChave(String chave) { this.chave = chave; }
    }

    @Test
    void copyProperty_DeveCopiarPropriedadeQuandoValorNaoEhNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanTeste bean = new BeanTeste();
        nullBeanUtils.copyProperty(bean, "chave", "valor");
        assertEquals("valor", bean.getChave());
    }

    @Test
    void copyProperty_NaoDeveCopiarQuandoValorEhNull() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanTeste bean = new BeanTeste();
        bean.setChave("valorAntigo");
        nullBeanUtils.copyProperty(bean, "chave", null);
        assertEquals("valorAntigo", bean.getChave());
    }
}
