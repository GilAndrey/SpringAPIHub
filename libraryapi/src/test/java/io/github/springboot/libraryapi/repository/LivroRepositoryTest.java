package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import io.github.springboot.libraryapi.model.GeneroLivro;
import io.github.springboot.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    // Titulos auto explicativos.

    @Test
    void salvarTest() {

        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("Ciencias da computaria");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        Autor autor = autorRepository.findById(UUID.fromString("4384f335-f17c-4505-a0de-a9a8d9117c58")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

    // Manual version - recommended
    @Test
    void salvarAutorELivroTest() {

        // Salva o autor
        Autor autor = new Autor();
        autor.setNome("Francisca");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1994, 9, 11));

        autorRepository.save(autor);

        // Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Francisca na casa");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        livro.setAutor(autor);

        repository.save(livro);

    }

    // Test with cascade, not recommended
    @Test
    void salvarCascadeTest() {
        Livro livro = new Livro();
        livro.setIsbn("41270-82347");
        livro.setPreco(BigDecimal.valueOf(800));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("Kama Sutra");
        livro.setDataPublicacao(LocalDate.of(2025, 2, 10));

        Autor autor = new Autor();
        autor.setNome("Venic");
        autor.setNacionalidade("Araripinense");
        autor.setDataNascimento(LocalDate.of(2004, 12, 24));

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
        UUID idLivro = UUID.fromString("bd569724-a7cf-40eb-8ac8-0819c86802ce");
        repository.deleteById(idLivro);
    }

    // Delete with cascade not recommend
    @Test
    void deletarCascade() {
        UUID idLivro = UUID.fromString("1201a3c3-3d22-43bb-b6d9-aa6cf30d5e5c");
        repository.deleteById(idLivro);
    }

    @Test
    @Transactional
    void buscarLivroTest() {
        UUID id = UUID.fromString("bfb15179-45b7-4f0e-88a8-b18e5b9cac0c");
        Livro livro = repository.findById(id).orElse(null);
        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());

        System.out.println("Autor: ");
        System.out.println(livro.getAutor().getNome());
    }

    @Test
    void pesquisaPorTituloTest() {
        List<Livro> list = repository.findByTitulo("298bc74b-a70d-4405-b82d-73d7d3455693");
        list.forEach(System.out::println);
    }

    @Test
    void pesquisarPorISBNTest() {
        Optional<Livro> livro = repository.findByIsbn("20847-84874");
        livro.ifPresent(System.out::println);
    }

    @Test
    void pesquisarPorTituloEPrecoTest() {
        var preco = BigDecimal.valueOf(100);
        var tituloPesquisa = "Objetos nao indentificados";

        List<Livro> list = repository.findByTituloAndPreco(tituloPesquisa, preco);
        list.forEach(System.out::println);
    }

    @Test
    void listarLivrosComQueryJPQL() {
        var resultado = repository.listarTodosPorTituloAndPreco();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarAutoresDosLivros() {
        var resultado = repository.listarAutoresDosLivros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarTitulosNaoRepetidoDosLivros() {
        var resultado = repository.listarNomesDiferentesLivros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarGenerosAutoresBrasileiros() {
        var resultado = repository.listarGenerosAutoresBrasileiros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroQueryParam() {
        var resultado = repository.findByGenero(GeneroLivro.MISTERIO, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void listarPorGeneroPositionalParam() {
        var resultado = repository.findByGeneroPositionalParameters(GeneroLivro.MISTERIO, "preco");
        resultado.forEach(System.out::println);
    }

    @Test
    void deletePorGeneroTest() {
        repository.deleteByGenero(GeneroLivro.CIENCIA);
   }

   @Test
    void updateDataPublicacaoTest() {
        repository.updateDataPublicacao(LocalDate.of(2000, 1, 1));
   }
}
