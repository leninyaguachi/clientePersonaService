package com.banco.clientepersonaservice.repository;

import com.banco.clientepersonaservice.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {}
