package org.example.spring.dev.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:22:00
 */
@Slf4j
public class OnUserCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("spring.bean.user.create", "on");

        log.info("OnUserCondition::matches -> {}", property);

        switch (property){
            case "on":
            case "ON":
            case "yes":
            case "YES":
                return true;
            default:
                return false;
        }
    }
}
