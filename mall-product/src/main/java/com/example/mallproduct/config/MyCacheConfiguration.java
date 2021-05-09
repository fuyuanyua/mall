package com.example.mallproduct.config;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Description: MyCacheConfiguration
 * @Author: lhb
 * @Date: 2021/5/9 20:26
 */

@EnableConfigurationProperties(CacheProperties.class)
@Configuration
public class MyCacheConfiguration {

    /**
     * 还需要把配置文件中配置的以spring.cache为前缀的属性加载进来
     * 以spring.cache为前缀的属性与CacheProperties这个配置类绑定
     * 1。源码中的CacheProperties类：
     *      @ConfigurationProperties(prefix = "spring.cache")
     *      但是并没有使用@Component注解将自己纳入容器
     * 2。把它纳入容器：
     *      所以我们手动使用@EnableConfigurationProperties注解，将CacheProperties纳入容器
     *
     * @return
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties) { //方法中传的参数，会自动从容器中获取
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        // 自定义key序列化机制
        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        // 自定义value序列化机制
        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        // 参考源码中的处理方式，使配置文件中配置的以spring.cache.redis为前缀的属性生效
        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
        if (redisProperties.getTimeToLive() != null) {
            config = config.entryTtl(redisProperties.getTimeToLive());
        }

        if (redisProperties.getKeyPrefix() != null) {
            config = config.prefixCacheNameWith(redisProperties.getKeyPrefix());
        }

        if (!redisProperties.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }

        if (!redisProperties.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        return config;
    }
}
