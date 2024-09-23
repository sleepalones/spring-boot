package org.example.spring.dev.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:47:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnMissingBeanConditionDev.class)
public @interface ConditionalOnMissingBeanDev {
    Class<?> value();
}
