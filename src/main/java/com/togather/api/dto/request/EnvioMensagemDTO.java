package com.togather.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para envio de mensagens.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvioMensagemDTO {
    
    private String conteudo;
    private String tipo;
    private String loginUsuario;
}

