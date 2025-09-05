package io.github.gilandrey.sbootexp_security.config;

import io.github.gilandrey.sbootexp_security.domain.security.CustomAuthentication;
import io.github.gilandrey.sbootexp_security.domain.service.IdentificacaoUsuario;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SenhaMasterAuthenticationProvider implements AuthenticationProvider {

    // Verificador de indentidade
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var login = authentication.getName();
        var senha = (String) authentication.getCredentials();

        String loginMaster = "master";
        String senhaMaster = "@321";

        if (loginMaster.equals(login) && senhaMaster.equals(senha)) {
            IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario(
                    "Sou Master",
                    "Master",
                    loginMaster,
                    List.of("ADMIN"));
            return new CustomAuthentication(identificacaoUsuario);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
