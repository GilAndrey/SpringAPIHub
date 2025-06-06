package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import io.github.springboot.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Interface do JPASpecification, ela adicona metodos de pesquisa.
public interface AutorRepository extends JpaRepository<Autor, UUID>{

    List<Autor> findByNome(String nome);
    List<Autor> findByNacionalidade(String nacionaldade);
    List<Autor> findByNomeAndNacionalidade(String nome, String nacionaldade);

    Optional<Autor> findByNomeAndDataNascimentoAndNacionalidade(String nome, LocalDate dataNascimento, String nacionalidade);
}
