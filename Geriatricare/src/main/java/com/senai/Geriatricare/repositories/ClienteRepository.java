package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    boolean existsByCnpj(String cnpj);
}
