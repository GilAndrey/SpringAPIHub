package io.github.springboot.libraryapi.controller.dto;

import io.github.springboot.libraryapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(

        UUID id,
        @NotBlank(message = "campo obrigatorio")
        String nome,
        @NotNull
        LocalDate dataNascimento,
        @NotBlank
        String nacionalidade) {


    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
