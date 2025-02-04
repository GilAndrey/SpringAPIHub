package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

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

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("5150f336-532a-432a-81b9-dc9a140ff4b9");
        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.println(possivelAutor.get());

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));
            repository.save(autorEncontrado);
        }
    }
}
