package com.togather.api.service;

import org.springframework.stereotype.Service;

import com.togather.api.dto.request.NovaSalaDTO;
import com.togather.api.dto.response.SalaDTO;

@Service
public interface SalaService {

    /**
     * Abre uma nova sala de bate-papo.
     * 
     * @param dto  DTO com os dados da nova sala
     * @return     Dados da nova sala aberta.
     */
    public SalaDTO abrirNova(NovaSalaDTO dto);
}
