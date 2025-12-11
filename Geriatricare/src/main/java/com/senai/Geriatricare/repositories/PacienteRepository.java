package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);

    List<PacienteModel> findAllByCliente(ClienteModel cliente);

    @Query("SELECT p FROM PacienteModel p WHERE p.id = :pacienteId AND p.cliente.id = :clienteId")
    Optional<PacienteModel> findByIdAndClienteId(@Param("pacienteId") Integer pacienteId, @Param("clienteId") Integer clienteId);
    PacienteModel findByClienteAndNome(ClienteModel cliente, String nome);
    PacienteModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    PacienteModel findByClienteAndRg(ClienteModel cliente, String rg);
    List<PacienteModel> findByClienteAndFamiliares(ClienteModel cliente, FamiliarModel familiar);
    List<PacienteModel> findByClienteAndStatusPaciente(ClienteModel cliente, String statusPaciente);
    List<PacienteModel> findByClienteAndGenero(ClienteModel cliente, String genero);
    List<PacienteModel> findByClienteAndPlano(ClienteModel cliente, String plano);
}
