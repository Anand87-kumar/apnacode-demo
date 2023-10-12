package com.anand.restapi;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
   public Docket swaggerApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.example"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Swagger API Example By Java",
            "API reference Example By Java",
            "1.0.0",
            "Public API",
            new Contact(
                "Java",
                "https://swagger.io/",
                "anandkr281198@gmail.com"),
            "API License Open",
            "https://swagger.io/");
    }
}
