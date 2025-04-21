package io.github.springboot.libraryapi.repository.specs;

import io.github.springboot.libraryapi.model.GeneroLivro;
import io.github.springboot.libraryapi.model.Livro;
import org.springframework.data.jpa.domain.Specification;

public class LivroSpecs {

    // Todos os parametros passados sao o resumo root = Dados navegaos, query = CriteriQuery e cb = CriteriBuilder
    // where isbn = :isbn -> Fazendo a comparaçao do get("isbn") com o isbn passado
    public static Specification<Livro> isbnEqual(String isbn) {
        return (root, query, cb) -> cb.equal(root.get("isb"), isbn);
    }

    // Para comparar o titulo do livro, e passando para Maisculo para melhor comparaçao
    public static Specification<Livro> tituloLike(String titulo) {
        // upper(livro.titulo) like (%:param)
        return (root, query, cb) -> cb.like(cb.upper(root.get("titulo")), "%" + titulo.toUpperCase() + "%");

    }

    // Para comparar o genero
    public static Specification<Livro> generoEqual(GeneroLivro genero) {
        return (root, query, cb) -> cb.equal(root.get("genero"), genero);
    }
}
