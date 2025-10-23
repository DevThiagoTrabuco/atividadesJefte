package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    PacienteModel findByClienteAndNome(ClienteModel cliente, String nome);
    PacienteModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    PacienteModel findByClienteAndRg(ClienteModel cliente, String rg);
    List<PacienteModel> findByClienteAndFamiliares(ClienteModel cliente, FamiliarModel familiar);
    List<PacienteModel> findByClienteAndStatusPaciente(ClienteModel cliente, String statusPaciente);
    List<PacienteModel> findByClienteAndGenero(ClienteModel cliente, String genero);
    List<PacienteModel> findByClienteAndPlano(ClienteModel cliente, String plano);
}
