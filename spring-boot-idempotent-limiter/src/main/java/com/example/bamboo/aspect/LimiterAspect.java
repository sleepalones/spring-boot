package com.example.bamboo.aspect;

import com.example.bamboo.annotation.Limiter;
import com.example.bamboo.util.RenderUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author brotherming
 * @createTime 2024年08月06日 22:54:00
 */
@Aspect
@Component
public class LimiterAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut(value = "@annotation(com.example.bamboo.annotation.Limiter)")
    private void printCut() {

    }

    @Around(value = "printCut()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes());

        HttpServletResponse response = servletRequestAttributes.getResponse();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Limiter limiter = signature.getMethod().getAnnotation(Limiter.class);

        // 获取限流数
        int value = limiter.value();

        // 验证有没有超过阈值
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("limiter.lua")));

        String key = "limiter:" + System.currentTimeMillis() / 1000;

        Long execute = stringRedisTemplate.execute(script, List.of(key), String.valueOf(value));

        if (execute != null && execute != 0) {
            return joinPoint.proceed();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("errCode", "509");
        result.put("errMsg", "网络拥堵，请稍后再试！");
        assert response != null;
        RenderUtil.render(response, result);

        return null;
    }

}
