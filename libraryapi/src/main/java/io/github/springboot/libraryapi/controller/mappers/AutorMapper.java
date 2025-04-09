package io.github.springboot.libraryapi.controller.mappers;

import io.github.springboot.libraryapi.controller.dto.AutorDTO;
import io.github.springboot.libraryapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    // Esse mapping é opicional, é utilizado quando os nomes dos complementos estão diferentes DTO e Entity
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "nacionalidade", target = "nacionalidade")
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}

// Mapper, facilita o uso dos DTO's e reduz o codigo repetitivo
