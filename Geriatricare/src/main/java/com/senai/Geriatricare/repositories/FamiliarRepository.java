package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliarRepository extends JpaRepository<FamiliarModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByRg(String rg);
    List<FamiliarModel> findByClienteAndNomeContaining(ClienteModel cliente, String nome);
    FamiliarModel findByClienteAndEmail(ClienteModel cliente, String email);
    FamiliarModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    FamiliarModel findByClienteAndRg(ClienteModel cliente, String rg);
    List<FamiliarModel> findByClienteAndPacientes(ClienteModel cliente, PacienteModel paciente);
}
