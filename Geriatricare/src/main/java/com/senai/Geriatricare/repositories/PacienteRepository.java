package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    PacienteModel findByClienteAndNome(ClienteModelModel cliente, String nome);
    PacienteModel findByClienteAndCpf(ClienteModelModel cliente, String cpf);
    PacienteModel findByClienteAndRg(ClienteModelModel cliente, String rg);
    List<PacienteModel> findByClienteAndFamiliares(ClienteModelModel cliente, FamiliarModel familiar);
    List<PacienteModel> findByClienteAndStatusPaciente(ClienteModelModel cliente, String statusPaciente);
    List<PacienteModel> findByClienteAndGenero(ClienteModelModel cliente, String genero);
    List<PacienteModel> findByClienteAndPlano(ClienteModelModel cliente, String plano);
}
