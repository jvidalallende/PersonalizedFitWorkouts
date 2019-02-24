package velascogculebras.personalizedfitworkouts.Configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {

    private String[] cacheNames = {"profile", "rutina", "index", "pdf", "rutinas", "trainers", "trainer", "favorites"};

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ConcurrentMapCache[] caches = new ConcurrentMapCache[cacheNames.length];
        for (int i = 0; i < caches.length; i++) {
            caches[i] = new ConcurrentMapCache(cacheNames[i]);
        }
        cacheManager.setCaches(Arrays.asList(caches));
        return cacheManager;
    }
}