package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    PacienteEntity findByNome(int clienteId, String nome);
    PacienteEntity findByCpf(String cpf);
    PacienteEntity findByRg(String rg);
    List<PacienteEntity> findByFamiliar(int clienteId, int familiarId);
    List<PacienteEntity> findByStatusPaciente(int clienteId, String statusPaciente);
    List<PacienteEntity> findByGenero(int clienteId, String genero);
    List<PacienteEntity> findByPlano(int clienteId, String plano);
}
