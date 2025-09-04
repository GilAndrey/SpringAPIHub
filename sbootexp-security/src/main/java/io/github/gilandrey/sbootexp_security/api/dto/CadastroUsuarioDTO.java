package io.github.gilandrey.sbootexp_security.api.dto;

import io.github.gilandrey.sbootexp_security.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {
    private Usuario usuario;
    private List<String> permissoes;
}
