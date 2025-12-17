package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Integer> {
    List<ContasAPagarModel> findByCliente(ClienteModel cliente);
    List<ContasAPagarModel> findByClienteAndTipoConta(ClienteModel cliente, String tipoConta);
    List<ContasAPagarModel> findByClienteAndStatusConta(ClienteModel cliente, StatusConta statusConta);
    List<ContasAPagarModel> findByClienteAndPacienteAndStatusConta(ClienteModel cliente, PacienteModel paciente, StatusConta status);
    List<ContasAPagarModel> findByClienteAndPaciente(ClienteModel cliente, PacienteModel paciente);
    Optional<ContasAPagarModel> findByClienteAndId(ClienteModel cliente, Integer id);
    boolean existsByClienteIdAndId(Integer clienteId, Integer id);
}
