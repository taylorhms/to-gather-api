package com.togather.api.dto.response;

import java.time.LocalDateTime;

import com.togather.api.entity.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    
    private String conteudo;
    private String tipo;
    private UsuarioDTO autor;
    private LocalDateTime dataEnvio;
    
    public MensagemDTO(Mensagem mensagem) {
        this(
            mensagem.getConteudo(),
            mensagem.getTipo(),
            new UsuarioDTO(mensagem.getAutor()),
            mensagem.getDataEnvio());
    }
}
