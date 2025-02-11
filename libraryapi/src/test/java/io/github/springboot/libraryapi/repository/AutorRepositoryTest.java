package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import io.github.springboot.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

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

    // Dont's work, maybe is because lombok in Autor is not work too. (Não funciona porem deve ser por causa do Lombok do autor que não esta funcionando)
    @Test
    public void listarTest() {
        List<Autor> list = repository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contaem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("6ac3cccf-bf57-4931-a67f-28f1c2f89e6e");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("374e8589-8808-4960-841d-bbed99040807");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void buscarLivroTest(){
        UUID id = UUID.fromString("bfb15179-45b7-4f0e-88a8-b18e5b9cac0c");
        Livro livro = livroRepository.findById(id).orElse(null);
        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());
        System.out.println("Autor: ");
        System.out.println(livro.getAutor().getNome());
    }

}
