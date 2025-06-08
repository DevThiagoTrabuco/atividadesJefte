package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.FamiliarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarRepository extends JpaRepository<FamiliarEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByRg(String rg);
    FamiliarEntity findByNome(int clienteId, String nome);
    FamiliarEntity findByEmail(int clienteId, String email);
    FamiliarEntity findByCpf(int clienteId, String cpf);
    FamiliarEntity findByRg(int clienteId, String rg);
    List<FamiliarEntity> findByPaciente(int clienteId, int pacienteId);
}
