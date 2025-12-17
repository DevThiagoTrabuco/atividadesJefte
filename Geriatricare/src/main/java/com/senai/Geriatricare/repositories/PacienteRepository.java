package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);

    List<PacienteModel> findAllByCliente(ClienteModel cliente);

    @Query("SELECT p FROM PacienteModel p WHERE p.id = :pacienteId AND p.cliente.id = :clienteId")
    Optional<PacienteModel> findByIdAndClienteId(@Param("pacienteId") Integer pacienteId, @Param("clienteId") Integer clienteId);
    List<PacienteModel> findByClienteAndNomeContaining(ClienteModel cliente, String nome);
    PacienteModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    PacienteModel findByClienteAndRg(ClienteModel cliente, String rg);
    List<PacienteModel> findByClienteAndFamiliares(ClienteModel cliente, FamiliarModel familiar);
    List<PacienteModel> findByClienteAndStatusPaciente(ClienteModel cliente, StatusPaciente statusPaciente);
    List<PacienteModel> findByClienteAndGenero(ClienteModel cliente, Genero genero);

    @Transactional
    @Modifying
    @Query("UPDATE PacienteModel p SET p.statusPaciente = :status WHERE p.id = :pacienteId AND p.cliente.id = :clienteId")
    void alterarStatus(@Param("pacienteId") Integer pacienteId, @Param("clienteId") Integer clienteId, @Param("status") StatusPaciente status);
}
