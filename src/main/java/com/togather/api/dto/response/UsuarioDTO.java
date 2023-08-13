package com.togather.api.dto.response;

import com.togather.api.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * DTO para retonar dados do usuario.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    private String login;
    private String nome;
    private String corPrimaria;
    private String corSecundaria;
    private byte[] foto;

    public UsuarioDTO(Usuario u) {
        this.login = u.getLogin();
        this.nome = u.getNome();
        this.corPrimaria = u.getCorPrimaria();
        this.corSecundaria = u.getCorSecundaria();
        this.foto = u.getFoto();
    }
}
