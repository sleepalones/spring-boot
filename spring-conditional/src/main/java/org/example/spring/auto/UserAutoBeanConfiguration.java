package org.example.spring.auto;

import org.example.spring.dev.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author brotherming
 * @createTime 2024年07月09日 22:46:00
 */
@Configuration
public class UserAutoBeanConfiguration {

    @ConditionalOnMissingBean(User.class)
    @Bean
    public User userAuto() {
        System.out.println("auto...");
        return new User("auto");
    }

}
