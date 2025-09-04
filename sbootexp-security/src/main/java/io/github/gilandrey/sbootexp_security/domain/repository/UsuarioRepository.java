package io.github.gilandrey.sbootexp_security.domain.repository;

import io.github.gilandrey.sbootexp_security.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
