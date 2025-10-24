package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarRepository extends JpaRepository<FamiliarModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByRg(String rg);
    FamiliarModel findByClienteAndNome(ClienteModelModel cliente, String nome);
    FamiliarModel findByClienteAndEmail(ClienteModelModel cliente, String email);
    FamiliarModel findByClienteAndCpf(ClienteModelModel cliente, String cpf);
    FamiliarModel findByClienteAndRg(ClienteModelModel cliente, String rg);
    List<FamiliarModel> findByClienteAndPacientes(ClienteModelModel cliente, PacienteModel paciente);
}
