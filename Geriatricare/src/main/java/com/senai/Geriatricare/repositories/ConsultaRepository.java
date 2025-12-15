package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ConsultaModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {
    List<ConsultaModel> findByCliente(ClienteModel cliente);
    List<ConsultaModel> findByClienteAndPaciente(ClienteModel cliente, PacienteModel paciente);
    List<ConsultaModel> findByClienteAndFuncionario(ClienteModel cliente, FuncionarioModel funcionario);
    Optional<ConsultaModel> findByIdAndCliente(Integer id, ClienteModel cliente);
}
