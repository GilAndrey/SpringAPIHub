package io.github.springboot.libraryapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Library API",
                version = "v1",
                contact = @Contact(
                        name = "Gil Andrey",
                        email = "gilandrey@hotmail.com",
                        url = "libraryapi.com"

                )
        )
)
public class OpenApiConfiguration {
}
