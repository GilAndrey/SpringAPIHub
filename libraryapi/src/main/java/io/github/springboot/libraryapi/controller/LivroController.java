package io.github.springboot.libraryapi.controller;

import io.github.springboot.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.springboot.libraryapi.controller.dto.ErroResposta;
import io.github.springboot.libraryapi.controller.mappers.LivroMapper;
import io.github.springboot.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.springboot.libraryapi.model.Livro;
import io.github.springboot.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto) {
        try {
            Livro livro = mapper.toEntity(dto); // Mapear dto para entidade
            service.salvar(livro); // Enviar a entidade para o service validar e salvar na base
            var url = gerarHeaderLocation(livro.getId()); // Cria uma url parra acesso dos dados do livro

            return ResponseEntity.created(url).build();

        }
        catch (RegistroDuplicadoException e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }

    }
}
