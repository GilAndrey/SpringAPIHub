package io.github.gilandrey.sbootexp_security.domain.security;

import io.github.gilandrey.sbootexp_security.domain.service.IdentificacaoUsuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

// Classe para a propria Logica de validação de Credenciais
public class CustomAuthentication implements Authentication {

    private final IdentificacaoUsuario indentificacao;

    public CustomAuthentication(IdentificacaoUsuario indentificacao) {
        if (indentificacao == null) {
            throw new ExceptionInInitializerError("Não é possivel criar um customAuthentication sem a indentificaçao do usuario");
        }
        this.indentificacao = indentificacao;
    }

    /**
     * Esse método é responsável por traduzir as permissões ou
     * os papéis de um usuário para um formato que o Spring Security consegue entender e usar para controlar o acesso.
     * */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.indentificacao
                .getPermissoes()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.indentificacao;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("Não é necessário chamar, já estou autenticado");
    }

    @Override
    public String getName() {
        return this.indentificacao.getNome();
    }
}
