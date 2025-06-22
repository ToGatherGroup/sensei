package sensei.config;

import com.togather.sensei.configs.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class MapperConfigurationTest {

    @Test
    void getModel_DeveRetornarModelMapper() {
        MapperConfiguration config = new MapperConfiguration();
        ModelMapper mapper = config.getModel();
        assertNotNull(mapper);
        assertTrue(mapper instanceof ModelMapper);
    }
}

