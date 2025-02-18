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
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    // livro (titulo,..., nome_arquivo) -> id.png
    @Transactional
    public void salvarLivroComFoto() {
        // salvar o livro
        // repository.save(livro);

        // pega o Id do livro = livro.getId();
        // var id = livro.getId();

        // salvar a foto do livro -> bucket na nuvem
        // bucketService.salvar(livro.getFoto(), id + ".png");

        // atualizar o nome do arquivo que foi salvo
        // livro.setNomeArquivoFoto(id + ".png");
        // repository.save(livro);
    }

    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository
                .findById(UUID.fromString("bfb15179-45b7-4f0e-88a8-b18e5b9cac0c"))
                .orElse(null);
        livro.setDataPublicacao(LocalDate.of(2024, 6, 1));
    }

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
