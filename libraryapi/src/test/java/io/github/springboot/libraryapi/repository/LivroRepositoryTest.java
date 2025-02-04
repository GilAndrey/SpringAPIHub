package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import io.github.springboot.libraryapi.model.GeneroLivro;
import io.github.springboot.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Objetos nao indentificados");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        Autor autor = autorRepository.findById(UUID.fromString("fe73bfd1-1b42-47f2-94ef-a90cddf31caa")).orElse(null);

        livro.setAutor(autor);
        repository.save(livro);

    }
}
