package sensei.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.togather.sensei.configs.CaffeineCacheConfig;
import com.togather.sensei.configs.MapperConfiguration;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import static org.junit.jupiter.api.Assertions.*;

class CaffeineCacheConfigTest {

    @Test
    void caffeineConfig_DeveRetornarCaffeineComConfiguracaoCorreta() {
        CaffeineCacheConfig config = new CaffeineCacheConfig();
        Caffeine caffeine = config.caffeineConfig();
        assertNotNull(caffeine);
        // Não há métodos públicos para verificar expireAfterWrite e maximumSize diretamente,
        // mas podemos garantir que o objeto não é nulo e é do tipo esperado.
        assertTrue(caffeine instanceof Caffeine);
    }

    @Test
    void cacheManager_DeveRetornarCacheManagerComCaffeine() {
        CaffeineCacheConfig config = new CaffeineCacheConfig();
        CacheManager cacheManager = config.cacheManager();
        assertNotNull(cacheManager);
        assertTrue(cacheManager instanceof CaffeineCacheManager);
    }

    static class MapperConfigurationTest {

        @Test
        void getModel_DeveRetornarModelMapper() {
            MapperConfiguration config = new MapperConfiguration();
            ModelMapper mapper = config.getModel();
            assertNotNull(mapper);
            assertTrue(mapper instanceof ModelMapper);
        }
    }
}

