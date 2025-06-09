package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    PacienteEntity findByClienteAndNome(ClienteEntity cliente, String nome);
    PacienteEntity findByClienteAndCpf(ClienteEntity cliente, String cpf);
    PacienteEntity findByClienteAndRg(ClienteEntity cliente, String rg);
    List<PacienteEntity> findByClienteAndFamiliares(ClienteEntity cliente, FamiliarEntity familiar);
    List<PacienteEntity> findByClienteAndStatusPaciente(ClienteEntity cliente, String statusPaciente);
    List<PacienteEntity> findByClienteAndGenero(ClienteEntity cliente, String genero);
    List<PacienteEntity> findByClienteAndPlano(ClienteEntity cliente, String plano);
}
