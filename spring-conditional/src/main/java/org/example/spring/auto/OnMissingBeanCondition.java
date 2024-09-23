package org.example.spring.auto;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:47:00
 */
public class OnMissingBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        String name = ConditionalOnMissingBean.class.getName();

        if (metadata.isAnnotated(name)) {
            Map<String, Object> attributes = metadata.getAnnotationAttributes(name);
            AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(attributes);

            assert annotationAttributes != null;
            Class<?> targetClass = annotationAttributes.getClass("value");

            ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

            try {
                assert beanFactory != null;
                beanFactory.getBean(targetClass);
                return false;
            } catch (NoSuchBeanDefinitionException e) {
                return true;
            }
        }
        return false;
    }
}
