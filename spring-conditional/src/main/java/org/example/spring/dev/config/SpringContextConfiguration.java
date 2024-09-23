package org.example.spring.dev.config;

import org.example.spring.auto.EnableUserAutoConfiguration;
import org.example.spring.dev.condition.ConditionalOnMissingBeanDev;
import org.example.spring.dev.entity.User;
import org.example.spring.imports.ImportSelectorImpl;
import org.example.spring.imports.ImportUserConfiguration;
import org.springframework.context.annotation.*;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:11:00
 */
@Configuration
@ComponentScan(basePackages = "org.example.spring.dev")
@PropertySource("classpath:application.properties")
//@Import(ImportUserConfiguration.class)  // 导入未扫描的配置
//@Import(ImportSelectorImpl.class)  // 导入未扫描的配置
@EnableUserAutoConfiguration
public class SpringContextConfiguration {

    /**
     * 基于配置文件，控制是否创建bean
     */
    /*@Conditional(OnUserCondition.class)
    @Bean
    public User user() {
        return new User();
    }*/

    /*@ConditionalOnMissingBeanDev(User.class)
    @Bean
    public User userAuto() {
        System.out.println("auto...");
        return new User("auto");
    }*/

    @Bean
    public User userDev() {
        System.out.println("dev...");
        return new User("dev");
    }

}
