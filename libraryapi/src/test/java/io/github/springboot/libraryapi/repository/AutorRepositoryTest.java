package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest() {
            Autor autor = new Autor();
            autor.setNome("Maria");
            autor.setNacionalidade("Brasileiro");
            autor.setDataNascimento(LocalDate.of(1980, 1, 10));

            var autorSalvo = repository.save(autor);
            System.out.println("Autor salvo: " + autorSalvo);
        }
}
