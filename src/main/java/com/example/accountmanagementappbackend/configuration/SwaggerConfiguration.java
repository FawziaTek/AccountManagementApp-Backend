package com.example.accountmanagementappbackend.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * SwaggerConfiguration class : in this class we will define our swagger configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public   GetPropertiesValue  readVariable ;

    @Bean
    public Docket postsApi() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(readVariable.getSwaggerBasePackage())).paths(PathSelectors.any()).
                build().apiInfo(apiInfo()) ;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(readVariable.getSwaggerTitle())
                .description(readVariable.getSwaggerDescription())
                .license(readVariable.getSwaggerLicense())
                .version(readVariable.getSwaggerVersionFromProp()).build();
    }


}
