package com.togather.api.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.togather.api.dto.request.AlterarUsuarioDTO;
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

    @GetMapping("/{id}")
    public UsuarioDTO consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

    @PostMapping
    public UsuarioDTO novaConta(@RequestBody NovaContaDTO dados) throws Exception {
        return service.novaConta(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterar(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token,
            @RequestBody AlterarUsuarioDTO dados) {

        return service.alterar(id, token, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagar(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token) {

        return service.apagar(id, token);
    }

    @PutMapping(value = "/foto/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> alterarFotoDePerfil(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token,
            @RequestPart("file") MultipartFile foto) throws IOException {

        return service.alterarFotoDePerfil(id, token, foto);
    }
}
