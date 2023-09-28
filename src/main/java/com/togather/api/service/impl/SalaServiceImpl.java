package com.togather.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.togather.api.dto.request.NovaSalaDTO;
import com.togather.api.dto.response.SalaDTO;
import com.togather.api.entity.Sala;
import com.togather.api.repository.SalaRepository;
import com.togather.api.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {
    
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public SalaDTO abrirNova(NovaSalaDTO dto) {
        Sala sala = new Sala();
        sala.setNome(dto.getNome());
        return new SalaDTO(salaRepository.save(sala));
    }
}
