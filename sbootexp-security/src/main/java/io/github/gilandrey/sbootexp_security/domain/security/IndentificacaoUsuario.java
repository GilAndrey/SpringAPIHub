package io.github.gilandrey.sbootexp_security.domain.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class IndentificacaoUsuario {

    private String id;
    private String nome;
    private String login;
    private List<String> permissoes;

    public IndentificacaoUsuario(String id, String nome, String login, List<String> permissoes) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.permissoes = permissoes;
    }

    public List<String> getPermissoes() {
        if (permissoes == null) {
            permissoes = new ArrayList<>();
        }
        return permissoes;
    }
}
