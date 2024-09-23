package com.example.bamboo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author brotherming
 * @createTime 2024年08月06日 22:53:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limiter {

    @AliasFor("limit")
    int value() default Integer.MAX_VALUE;

    int limit() default Integer.MAX_VALUE;

}
