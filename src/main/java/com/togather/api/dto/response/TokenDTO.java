package com.togather.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para retonar dados do usuario para acesso aos demais endpoints.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
    private String token;
    private String usuarioLogin;
}
