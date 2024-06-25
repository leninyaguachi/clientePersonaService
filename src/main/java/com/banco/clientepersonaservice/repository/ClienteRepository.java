package com.banco.clientepersonaservice.repository;

import com.banco.clientepersonaservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
