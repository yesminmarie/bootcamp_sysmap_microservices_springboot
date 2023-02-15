package io.github.yesminmarie.mslearningattendance.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi
                .builder()
                .group("Attendance API")
                .addOpenApiCustomiser(statusApiCostumizer())
                .build();
    }

    private OpenApiCustomiser statusApiCostumizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("MS Learning Attendance")
                        .description("Microservice for register attendances.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Yesmin Lahoud")
                                .url("https://github.com/yesminmarie")
                                .email("ymslahoud@gmail.com")));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("MS Learning Attendance").description(
                        "Microservice for register attendances."));
    }
}
