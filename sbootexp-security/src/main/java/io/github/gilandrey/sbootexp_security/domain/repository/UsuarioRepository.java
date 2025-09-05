package io.github.gilandrey.sbootexp_security.domain.repository;

import io.github.gilandrey.sbootexp_security.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByLogin(String login);
}
