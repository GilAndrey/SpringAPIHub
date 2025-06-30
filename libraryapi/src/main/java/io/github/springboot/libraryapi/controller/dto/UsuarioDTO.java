package io.github.springboot.libraryapi.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Schema(name = "Usuario")
public record UsuarioDTO(
        @NotBlank(message = "Campo obrigatorio")
        String login,
        @Email(message = "Email Invalid!")
        @NotBlank(message = "Campo obrigatorio")
        String email,
        @NotBlank(message = "Campo obrigatorio")
        String senha,
        List<String> roles) {
}
