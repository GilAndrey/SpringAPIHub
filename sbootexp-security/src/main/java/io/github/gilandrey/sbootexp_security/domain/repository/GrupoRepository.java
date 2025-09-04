package io.github.gilandrey.sbootexp_security.domain.repository;

import io.github.gilandrey.sbootexp_security.domain.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, String> {
}
