package com.togather.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.togather.api.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
    List<Mensagem> findByOrderByDataEnvioDesc();
}
