package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    boolean existsByCnpj(String cnpj);
    ClienteModel findByCnpj(String cnpj);
    ClienteModel findByEmail(String email);
    ClienteModel findByNome(String nome);
}
