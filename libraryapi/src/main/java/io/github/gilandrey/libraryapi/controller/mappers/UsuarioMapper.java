package io.github.gilandrey.libraryapi.controller.mappers;

import io.github.gilandrey.libraryapi.controller.dto.UsuarioDTO;
import io.github.gilandrey.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
