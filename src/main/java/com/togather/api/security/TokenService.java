package com.togather.api.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.togather.api.dto.response.TokenDTO;
import com.togather.api.entity.Usuario;

@Service
public class TokenService {

    private static final String TOKEN_SECRET = "S3cr3t";

    public TokenDTO gerarToken(Usuario usuario) {
        return new TokenDTO(JWT.create()
                .withIssuer("Issuer")
                .withSubject(usuario.getUsername())
                .withExpiresAt(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(TOKEN_SECRET)));
    }
    
}
