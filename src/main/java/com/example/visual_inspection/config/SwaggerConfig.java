package com.example.visual_inspection.config;

import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact()
                .name("JAYAKISHORE")
                .email("jayakishore7077@gmail.com");

        Info info = new Info()
                .title("Visual_Inspection")
                .version("1.0")
                .description("API for Visual_inspection")
                .contact(contact);

        return new OpenAPI().info(info);
    }
    }

