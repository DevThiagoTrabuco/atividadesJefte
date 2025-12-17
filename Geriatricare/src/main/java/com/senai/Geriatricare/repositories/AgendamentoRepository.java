package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.StatusAgendamento;
import com.senai.Geriatricare.models.AgendamentoModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Integer> {
    Optional<AgendamentoModel> findByIdAndCliente(Integer id, ClienteModel cliente);
    List<AgendamentoModel> findByCliente(ClienteModel cliente);
    List<AgendamentoModel> findByClienteAndPaciente(ClienteModel cliente, PacienteModel paciente);
    List<AgendamentoModel> findByClienteAndData(ClienteModel cliente, LocalDate data);
    List<AgendamentoModel> findByClienteAndProcedimentoContaining(ClienteModel cliente, String procedimento);
    List<AgendamentoModel> findByClienteAndStatusAgendamento(ClienteModel cliente, StatusAgendamento statusAgendamento);
}
