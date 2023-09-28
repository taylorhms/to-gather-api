package com.togather.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.togather.api.ToGatherApiApplicationTests;
import com.togather.api.dto.request.NovaSalaDTO;
import com.togather.api.dto.response.SalaDTO;

public class SalaServiceTests extends ToGatherApiApplicationTests {
    
    @Autowired
    SalaService salaService;

    @Test
    void deveriaCriarUmaNovaSala() {
        NovaSalaDTO novaDto = new NovaSalaDTO();
        novaDto.setNome("Sala 1");
        
        SalaDTO salaDto = salaService.abrirNova(novaDto);

        assertEquals(novaDto.getNome(), salaDto.getNome());
    }

}
