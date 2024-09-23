package com.example.bamboo.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author brotherming
 * @createTime 2024年08月06日 23:00:00
 */
@Component
public class TokenService {

    public static final String IDEMPOTENT_TOKEN = "idempotent:token:";
    public static final String VALIDATE_TOKEN_LUA = "if (redis.call('exists', KEYS[1]) == 1) then return redis.call('del', KEYS[1]) else return 0 end";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String generateToken() {
        String token = UUID.randomUUID().toString();
        String key = IDEMPOTENT_TOKEN + token;
        stringRedisTemplate.opsForValue().set(key, token, 10, TimeUnit.MINUTES);
        return token;
    }

    public boolean validateToken(String token) {
        String key = IDEMPOTENT_TOKEN + token;

        RedisScript<Long> redisScript = new DefaultRedisScript<>(VALIDATE_TOKEN_LUA, Long.class);
        Long result = stringRedisTemplate.execute(redisScript, List.of(key));

        return result != null && result != 0;
    }
}
