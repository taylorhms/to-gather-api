package com.togather.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioMensagemDTO {
    
    private String conteudo;
    private String tipo;
    private String loginUsuario;
}

