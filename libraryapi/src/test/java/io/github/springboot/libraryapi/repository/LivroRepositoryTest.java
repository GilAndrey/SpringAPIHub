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
        livro.setTitulo("Livros de ficcao");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        Autor autor = autorRepository.findById(UUID.fromString("fe73bfd1-1b42-47f2-94ef-a90cddf31caa")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

    // Manual version - recommended
    @Test
    void salvarAutorELivroTest() {
        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Xo xing xho li");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        Autor autor = new Autor();
        autor.setNome("Xing lang in");
        autor.setNacionalidade("Chinese");
        autor.setDataNascimento(LocalDate.of(1994, 9, 11));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

    // Test with cascade, not recommended
    @Test
    void salvarCascadeTest() {
        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("The promise of never lands");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        Autor autor = new Autor();
        autor.setNome("HollandJr");
        autor.setNacionalidade("Inglis");
        autor.setDataNascimento(LocalDate.of(1964, 5, 27));

        livro.setAutor(autor);

        repository.save(livro);
    }

    @Test
    void atualizarAutorDoLivro() {

        UUID idLivro = UUID.fromString("e7b25fdb-567c-410e-971f-159ac66fcb6c");
        var livroParaAtualizar = repository.findById(idLivro).orElse(null);

        UUID idAutor = (UUID.fromString("fe73bfd1-1b42-47f2-94ef-a90cddf31caa"));
        Autor autor = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autor);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletar() {
        UUID idLivro = UUID.fromString("5ea1b9f4-8c05-4ed9-bed5-cf6361eb9425");
        repository.deleteById(idLivro);
    }

    // Delete with cascade not recommend
    @Test
    void deletarCascade() {
        UUID idLivro = UUID.fromString("1201a3c3-3d22-43bb-b6d9-aa6cf30d5e5c");
        repository.deleteById(idLivro);
    }
}
