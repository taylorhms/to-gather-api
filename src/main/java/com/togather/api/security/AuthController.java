package com.togather.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.togather.api.dto.request.LoginDTO;
import com.togather.api.dto.response.TokenDTO;
import com.togather.api.entity.Usuario;

@RestController
public class AuthController {
    
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO login) {
        UsernamePasswordAuthenticationToken uToken =
                new UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha());

        Authentication auth = authManager.authenticate(uToken);
        Usuario usuario = (Usuario) auth.getPrincipal();

        String token = tokenService.gerarToken(usuario);
        return new TokenDTO(token, usuario.getLogin());
    }
}
