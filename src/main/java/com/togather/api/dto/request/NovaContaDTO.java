package com.togather.api.dto.request;

import lombok.Data;

@Data
public class NovaContaDTO {
    
    private String login;
    private String nome;
    private String senha;
    private String cofirmaSenha;
}
