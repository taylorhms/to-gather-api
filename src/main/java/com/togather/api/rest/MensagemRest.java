package com.togather.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.togather.api.dto.request.EnvioMensagemDTO;
import com.togather.api.dto.response.MensagemDTO;
import com.togather.api.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemRest {
    
    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public List<MensagemDTO> todas() {
        return mensagemService.todas();
    }

    @PostMapping
    public MensagemDTO enviar(@RequestBody EnvioMensagemDTO mensagem) {
        return mensagemService.enviar(mensagem);
    }
}
