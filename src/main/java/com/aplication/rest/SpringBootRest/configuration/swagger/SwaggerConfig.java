package com.aplication.rest.SpringBootRest.configuration.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API DEMO",
                description = "Our app provides the methods of two related Entity ",
                termsOfService = "www.proyectosjuan.com/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Juan Pablo Marin",
                        url = "https://proyectosjuan.com",
                        email = "jupamarin@gmail.com"
                ),
                license = @License(
                        name = "Standard Software Use License for every body",
                        url = "www.proyectosjuan.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://proyectosjuan:8080"
                )
       },
        security = {
        @SecurityRequirement(name = "BearerAuth")
                }
                        )
        @SecurityScheme(
                name = "BearerAuth",
                description = "Access Token for API (Bearer JWT)",
                type = SecuritySchemeType.HTTP,
                scheme = "bearer",
                bearerFormat = "JWT",
                paramName = HttpHeaders.AUTHORIZATION,
                in = SecuritySchemeIn.HEADER
        )
public class SwaggerConfig {}