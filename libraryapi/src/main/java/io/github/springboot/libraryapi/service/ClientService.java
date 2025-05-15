package io.github.springboot.libraryapi.service;

import io.github.springboot.libraryapi.model.Client;
import io.github.springboot.libraryapi.repository.ClientRepository;
import io.github.springboot.libraryapi.validator.ClientValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientValidator validator;
    private final PasswordEncoder encoder;

    public Client salvar(Client client) {
        var senhaCriptografada = encoder.encode(client.getClientSecret());
        client.setClientSecret(senhaCriptografada);
        validator.validar(client);
        return repository.save(client);
    }

    public Client obterPorClinetID(String clientId) {

        return repository.findByClientId(clientId);
    }

}
