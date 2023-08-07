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
    private static final String ISSUER = "Issuer";

    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }
    
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET))
                .withIssuer(ISSUER)
                .build().verify(token).getSubject();
    }
}
