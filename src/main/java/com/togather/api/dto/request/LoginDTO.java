package com.togather.api.dto.request;

import lombok.Data;

/**
 * DTO para solicitar autenticação.
 */
@Data
public class LoginDTO {
    
    public String login;
    public String senha;
}
