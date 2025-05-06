package io.github.springboot.libraryapi.controller.mappers;

import io.github.springboot.libraryapi.controller.dto.UsuarioDTO;
import io.github.springboot.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

}
