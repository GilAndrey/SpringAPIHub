package io.github.springboot.libraryapi.repository;

import io.github.springboot.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    List<Autor> findByNome(String nome);
    List<Autor> findByNacionalidade(String nacionaldade);
    List<Autor> findByNomeAndNacionalidade(String nome, String nacionaldade);
}
