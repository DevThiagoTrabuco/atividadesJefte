package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    boolean existsByCnpj(String cnpj);
}
