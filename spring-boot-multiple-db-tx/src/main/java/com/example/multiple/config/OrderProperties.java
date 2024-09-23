package com.example.multiple.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author brotherming
 * @createTime 2024年07月28日 12:03:00
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.order")
@Data
public class OrderProperties {

    private String jdbcUrl;

    private String username;

    private String password;

    private String driverClassName;

}
