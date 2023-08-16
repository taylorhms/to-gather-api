package com.togather.api.dto.request;

import lombok.Data;

@Data
public class AlterarUsuarioDTO {

    private String nome;
    private String corPrimaria;
    private String corSecundaria;
    private byte[] foto;
}
