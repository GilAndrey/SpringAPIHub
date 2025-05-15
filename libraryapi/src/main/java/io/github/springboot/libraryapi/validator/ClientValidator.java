package io.github.springboot.libraryapi.validator;

import io.github.springboot.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.springboot.libraryapi.model.Client;
import io.github.springboot.libraryapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientValidator {


    @Autowired
    private ClientRepository repository;

    public void validar(Client client) {
        if (existeIdClient(client)) {
            throw new RegistroDuplicadoException("Esse client já existe!!");
        }
    }

    private boolean existeIdClient(Client client) {
        if (client.getId() == null) {
            return false;
        }

        return repository.findById(client.getId()).isPresent();
    }
}
