package com.togather.api.dto.response;

import com.togather.api.entity.Sala;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalaDTO {
    
    private Long id;
    private String nome;

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.nome = sala.getNome();
    }
}
