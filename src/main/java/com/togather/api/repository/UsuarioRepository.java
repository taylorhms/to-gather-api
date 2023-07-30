package com.togather.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.togather.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByLogin(String login);
}
