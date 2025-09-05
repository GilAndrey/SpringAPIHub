package io.github.gilandrey.sbootexp_security.config;

import io.github.gilandrey.sbootexp_security.domain.entity.Usuario;
import io.github.gilandrey.sbootexp_security.domain.security.CustomAuthentication;
import io.github.gilandrey.sbootexp_security.domain.security.IndentificacaoUsuario;
import io.github.gilandrey.sbootexp_security.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String senha = (String) authentication.getCredentials();

        // Obtém o usuário do serviço, valida a senha de forma segura e retorna uma autenticação customizada em caso de sucesso.
        Usuario usuario = usuarioService.obterUsuarioComPermissoes(login);
        if (usuario != null) {
            boolean senhasBatem = passwordEncoder.matches(senha, usuario.getSenha());// .matches, utilizado para comparar senhas (senha crua, get.senha criptografada)
            if (senhasBatem) {
                IndentificacaoUsuario indentificacaoUsuario = new IndentificacaoUsuario(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getLogin(),
                        usuario.getPermissoes()
                );
                return new CustomAuthentication(indentificacaoUsuario);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
