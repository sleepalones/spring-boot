package org.example.spring.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author brotherming
 * @createTime 2024年07月09日 23:08:00
 */
public class ImportSelectorImpl implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // AnnotationMetadata 获得作用 @Import 注解类
        return new String[]{ImportUserConfiguration.class.getName()};
    }
}
