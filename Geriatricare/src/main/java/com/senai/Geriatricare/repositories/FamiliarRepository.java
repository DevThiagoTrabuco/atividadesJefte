package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarRepository extends JpaRepository<FamiliarEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByRg(String rg);
    FamiliarEntity findByClienteAndNome(ClienteEntity cliente, String nome);
    FamiliarEntity findByClienteAndEmail(ClienteEntity cliente, String email);
    FamiliarEntity findByClienteAndCpf(ClienteEntity cliente, String cpf);
    FamiliarEntity findByClienteAndRg(ClienteEntity cliente, String rg);
    List<FamiliarEntity> findByClienteAndPacientes(ClienteEntity cliente, PacienteEntity paciente);
}
