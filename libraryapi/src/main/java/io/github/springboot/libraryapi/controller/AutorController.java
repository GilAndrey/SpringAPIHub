package io.github.springboot.libraryapi.controller;

import io.github.springboot.libraryapi.controller.dto.AutorDTO;
import io.github.springboot.libraryapi.model.Autor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/autores
@RestController
@RequestMapping("/autores")
public class AutorController {

    @PostMapping
    public ResponseEntity salvar(@RequestBody AutorDTO autor) {
        return new ResponseEntity("autor salvo com sucesso! " + autor, HttpStatus.CREATED);
    }
}
