package io.github.springboot.libraryapi.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

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
