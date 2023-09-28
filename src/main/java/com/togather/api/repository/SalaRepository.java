package com.togather.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.togather.api.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
