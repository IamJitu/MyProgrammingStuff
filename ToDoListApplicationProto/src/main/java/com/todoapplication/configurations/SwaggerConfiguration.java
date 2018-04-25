package com.todoapplication.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for setting up Swagger for the application
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String BASE_PACKAGE = "com.todoapplication.controller";

    /**
     * Api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Access, Delete, Update, Save, Add TODO Tasks",
                "This API allows to access the details of Task",
                "v1", "TODO Application", new Contact("", "", ""), "", "");
    }

    /**
     *
     * @return Swagger Docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.ant("/*")).build().apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .forCodeGeneration(true);
    }
}
