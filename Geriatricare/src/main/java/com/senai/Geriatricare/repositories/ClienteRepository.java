package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    boolean existsByCnpj(String cnpj);
    ClienteModel findByCnpj(String cnpj);
    ClienteModel findByEmail(String email);
    List<ClienteModel> findByNome(String nome);
}
