package com.togather.api.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.togather.api.entity.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para retornar mensagens.
 * Utilize loginAutor para identificar os usuarios.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    
    private String conteudo;
    private String tipo;
    private String loginAutor;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm") private LocalDateTime dataEnvio;
    
    public MensagemDTO(Mensagem mensagem) {
        this.conteudo = mensagem.getConteudo();
        this.tipo = mensagem.getTipo();
        this.dataEnvio = mensagem.getDataEnvio();
        this.loginAutor = mensagem.getAutor().getLogin();
    }
}
