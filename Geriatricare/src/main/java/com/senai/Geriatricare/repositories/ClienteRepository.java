package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    boolean existsByCnpj(String cnpj);
    ClienteEntity findByCnpj(String cnpj);
    ClienteEntity findByEmail(String email);
    ClienteEntity findByNome(String nome);
}
