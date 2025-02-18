package io.github.springboot.libraryapi.service;

import io.github.springboot.libraryapi.model.Autor;
import io.github.springboot.libraryapi.model.GeneroLivro;
import io.github.springboot.libraryapi.model.Livro;
import io.github.springboot.libraryapi.repository.AutorRepository;
import io.github.springboot.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void executar() {

        // Salva o autor
        Autor autor = new Autor();
        autor.setNome("Teste Francisco");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1994, 9, 11));

        autorRepository.save(autor);

        // Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("90029-84732");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setTitulo("Teste Livro do Francisco");
        livro.setDataPublicacao(LocalDate.of(1980, 2, 2));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if (autor.getNome().equals("Teste Francisco")) {
         throw new RuntimeException("Rollback");
        }
    }
}
