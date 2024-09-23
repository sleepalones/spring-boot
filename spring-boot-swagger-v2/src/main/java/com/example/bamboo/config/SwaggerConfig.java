package com.example.bamboo.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author brotherming
 * @createTime 2024年08月02日 21:24:00
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket userDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("USER管理系统接口文档")
                .description("集成Swagger2构建接口文档")
                .termsOfServiceUrl("http://www.bamboo/ming")
                .contact(new Contact("wym", "http://www.bamboo/ming", "bamboo@163.com"))
                .license("Apache 2.0 开源许可证")
                .licenseUrl("XXX")
                .version("1.0.0")
                .extensions(List.of(new StringVendorExtension("XXX", "http://www.bamboo/ming")))
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("user group")
                .ignoredParameterTypes(HttpServletRequest.class,HttpServletRequest.class, HttpSession.class)
                // 过滤和筛选 api
                .select()
                //.apis(RequestHandlerSelectors.any())  // 任何api都展示
                //.apis(RequestHandlerSelectors.none())  // 任何api都不展示
                //.apis(RequestHandlerSelectors.basePackage("com.example.bamboo.controller"))  // 选择某个包下的API进行展示
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))  // 类上标记的注解进行展示
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  // 方法上标记的注解进行展示
                .paths(PathSelectors.any())
                //.paths(PathSelectors.none())
                //.paths(PathSelectors.ant("/user/**"))
                //.paths(PathSelectors.regex("/goods/.*"))
                .build();
    }

    @Bean
    public Docket goodsDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("GOODS管理系统接口文档")
                .description("集成Swagger2构建接口文档")
                .termsOfServiceUrl("http://www.bamboo/ming")
                .contact(new Contact("wym", "http://www.bamboo/ming", "bamboo@163.com"))
                .license("Apache 2.0 开源许可证")
                .licenseUrl("XXX")
                .version("1.0.0")
                .extensions(List.of(new StringVendorExtension("XXX", "http://www.bamboo/ming")))
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("goods group");
    }
}
