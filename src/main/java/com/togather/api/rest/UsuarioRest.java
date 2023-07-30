package com.togather.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.togather.api.dto.request.NovaContaDTO;
import com.togather.api.dto.response.UsuarioDTO;
import com.togather.api.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> todos() {
        return service.todos();
    }

    @PostMapping
    public UsuarioDTO novaConta(@RequestBody NovaContaDTO dados) throws Exception {
        return service.novaConta(dados);
    }
}
