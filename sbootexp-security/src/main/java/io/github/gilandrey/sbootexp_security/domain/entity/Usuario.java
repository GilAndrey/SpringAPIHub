package io.github.gilandrey.sbootexp_security.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String senha;

    private String nome;
}
