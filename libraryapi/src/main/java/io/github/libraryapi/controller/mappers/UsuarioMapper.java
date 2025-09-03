package io.github.libraryapi.controller.mappers;

import io.github.libraryapi.controller.dto.UsuarioDTO;
import io.github.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
