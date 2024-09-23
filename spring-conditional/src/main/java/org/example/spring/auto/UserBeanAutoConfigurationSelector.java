package org.example.spring.auto;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author brotherming
 * @createTime 2024年07月09日 22:57:00
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class UserBeanAutoConfigurationSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String name = UserAutoBeanConfiguration.class.getName();
        return new String[]{name};
    }
}
