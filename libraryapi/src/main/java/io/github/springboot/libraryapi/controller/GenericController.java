package io.github.springboot.libraryapi.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public interface GenericController {

    // A utilização desse metodo é util pra construir o
    // link do recurso recém-criado, e é uma boa prática REST retornar esse
    // link no header Location ao responder com 201 Created.
    default URI gerarHeaderLocation(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
