package com.example.bamboo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author brotherming
 * @createTime 2024年08月04日 14:12:00
 */
@Configuration
public class CacheConfig {

    @Bean
    public KeyGenerator myKeyGenerator() {
        return (target, method, params) ->
                target.getClass().getSimpleName() + "_" +
                        method.getName() + "_" +
                        StringUtils.arrayToDelimitedString(params, "_");
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        config.setCodec(new StringCodec());
        return Redisson.create(config);
    }

}
