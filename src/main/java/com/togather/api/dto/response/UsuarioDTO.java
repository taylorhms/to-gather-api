package com.togather.api.dto.response;

import com.togather.api.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    private String login;
    private String nome;

    public UsuarioDTO(Usuario u) {
        this(u.getLogin(), u.getNome());
    }
}
