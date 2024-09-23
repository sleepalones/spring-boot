package org.example.spring.imports;

import org.example.spring.dev.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author brotherming
 * @createTime 2024年07月09日 23:06:00
 */
@Configuration
public class ImportUserConfiguration {
    @Bean
    public User user() {
        System.out.println("import...");
        return new User("@Import");
    }
}
