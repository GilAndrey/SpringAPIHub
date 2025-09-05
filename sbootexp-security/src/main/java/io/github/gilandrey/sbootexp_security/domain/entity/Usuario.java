package io.github.gilandrey.sbootexp_security.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String login;

    private String senha;

    private String nome;

    @Transient // É utilizada qunado voce quer ignorar o mapeamento JPA
    private List<String> permissoes;
}
