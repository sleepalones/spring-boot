v 2.10.5  localhost:8080/swagger/swagger-ui.html
    pom.xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.10.5</version>
            <exclusions>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-models</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
            <version>1.5.21</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.10.5</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-spring-webmvc</artifactId>
            <version>2.10.5</version>
        </dependency>
    SwaggerConfig.java
        @EnableSwagger2WebMvc
        paths(PathSelectors.ant("/**/user/**"))匹配时需要加上配置的项目path


v 3.0.0  localhost:8080/swagger/swagger-ui
    pom.xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>3.0.0</version>
            <exclusions>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-models</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
            <version>1.5.21</version>
        </dependency>

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>3.0.0</version>
        </dependency>

    SwaggerConfig.java
        @EnableSwagger2

        SwaggerConfig implements WebMvcConfigurer

        paths(PathSelectors.ant("/**/user/**"))匹配时需要加上配置的项目path

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/swagger-ui/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        }

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/swagger-ui/")
                    .setViewName("forward:" + "/swagger-ui/index.html");
        }

v 3.0.0 starter 方式  localhost:8080/swagger/swagger-ui
    pom.xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>

    SwaggerConfig.java
        只需要配置 Docket
        paths(PathSelectors.ant("/**/user/**"))匹配时需要加上配置的项目path

knife4j  localhost:8080/swagger/doc.html
    pom.xml
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>2.0.5</version> // 对应swagger 2.9.2
        </dependency>
    SwaggerConfig.java
        @EnableKnife4j
        @EnableSwagger2
