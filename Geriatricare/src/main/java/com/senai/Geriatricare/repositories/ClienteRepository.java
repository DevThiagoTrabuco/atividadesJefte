package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModelModel, Integer> {
    boolean existsByCnpj(String cnpj);
    ClienteModelModel findByCnpj(String cnpj);
    ClienteModelModel findByEmail(String email);
    ClienteModelModel findByNome(String nome);
}
