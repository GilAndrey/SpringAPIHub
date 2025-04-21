package io.github.springboot.libraryapi.controller;

import io.github.springboot.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.springboot.libraryapi.controller.dto.ResultadoPesquisaLivroDTO;
import io.github.springboot.libraryapi.controller.mappers.LivroMapper;
import io.github.springboot.libraryapi.model.Livro;
import io.github.springboot.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid CadastroLivroDTO dto) {

        Livro livro = mapper.toEntity(dto); // Mapear dto para entidade
        service.salvar(livro); // Enviar a entidade para o service validar e salvar na base
        var url = gerarHeaderLocation(livro.getId()); // Cria uma url parra acesso dos dados do livro

        return ResponseEntity.created(url).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ResultadoPesquisaLivroDTO> obterDetalhes(@PathVariable("id") String id) {
        return service.obterPorId(UUID.fromString(id)).map(livro -> {
            var dto = mapper.toDTO(livro);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
