package io.github.springboot.libraryapi.controller.dto;

import io.github.springboot.libraryapi.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(String isbn,
                               String titulo,
                               LocalDate dataPublicacao,
                               GeneroLivro genero,
                               BigDecimal preco,
                               UUID idAutor) {
}
