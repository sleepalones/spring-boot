package com.example.bamboo.aspect;

import com.example.bamboo.token.TokenService;
import com.example.bamboo.util.RenderUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author brotherming
 * @createTime 2024年08月06日 22:54:00
 */
@Aspect
@Component
public class IdempotentAspect {

    @Autowired
    private TokenService tokenService;

    @Pointcut(value = "@annotation(com.example.bamboo.annotation.ApiIdempotent)")
    private void printCut() {

    }

    @Around(value = "printCut()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes());

        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        String token = request.getHeader("token");
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.hasText(token)) {
            if (!tokenService.validateToken(token)) {
                result.put("errCode", "509");
                result.put("errMsg", "请勿重复操作");
                assert response != null;
                RenderUtil.render(response, result);
                return null;
            }
        }else {
            result.put("errCode", "400");
            result.put("errMsg", "缺少token");
            assert response != null;
            RenderUtil.render(response, result);
            return null;
        }
        return joinPoint.proceed();
    }

}
