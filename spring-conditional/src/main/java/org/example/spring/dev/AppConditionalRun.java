package org.example.spring.dev;

import org.example.spring.dev.config.SpringContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author brotherming
 * @createTime 2024年07月08日 21:13:00
 */
public class AppConditionalRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringContextConfiguration.class);

        context.close();
    }

}
