package io.github.springboot.libraryapi.security;

import io.github.springboot.libraryapi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomRegisteredClientRepository implements RegisteredClientRepository {

    private final ClientService service;

    @Override
    public void save(RegisteredClient registeredClient) {
    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client = service.obterPorClientID(clientId);

        if (client == null) {
            return null;
        }

        return RegisteredClient
                .withId(client.getId().toString())   // Define o ID interno único do cliente (pode ser UUID)
                .clientId(client.getClientId())   // Define o client_id que será usado para autenticação (ex: "app-web")
                .clientSecret(client.getClientSecret())  // Define o client_secret usado para autenticação segura com o Authorization Server
                .redirectUri(client.getRedirectURI())   // Define a URI para redirecionamento após login com sucesso (fluxo Authorization Code)
                .scope(client.getScope()) // Define os escopos de acesso permitidos para esse cliente (ex: "read", "write")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)  // Define o método de autenticação do cliente (neste caso: client_id + secret no header)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE) // Permite o tipo de grant "authorization_code" (fluxo com redirecionamento e login de usuário)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)  // Também permite "client_credentials" (sem login de usuário, usado entre sistemas)
//                .tokenSettings()
//                .clientSettings()
                .build();
    }
}
