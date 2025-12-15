package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.AgendamentoEntity;
import com.senai.Geriatricare.models.AgendamentoModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.AgendamentoRepository;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public AgendamentoModel criarAgendamento(AgendamentoEntity agendamentoEntity) {
        ClienteModel cliente = clienteRepository.findById(agendamentoEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + agendamentoEntity.getClienteId()));
        PacienteModel paciente = pacienteRepository.findById(agendamentoEntity.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + agendamentoEntity.getPacienteId()));

        AgendamentoModel agendamento = agendamentoEntity.toEntity(cliente, paciente);
        return agendamentoRepository.save(agendamento);
    }

    public AgendamentoModel buscarPorClienteEId(Integer clienteId, Integer agendamentoId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return agendamentoRepository.findByIdAndCliente(agendamentoId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com o ID " + agendamentoId + " não encontrado para o cliente " + clienteId));
    }

    public List<AgendamentoModel> buscarPorCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return agendamentoRepository.findByCliente(cliente);
    }

    public List<AgendamentoModel> buscarPorClienteEPaciente(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return agendamentoRepository.findByClienteAndPaciente(cliente, paciente);
    }

    public List<AgendamentoModel> buscarPorClienteEDataHora(Integer clienteId, LocalDateTime data) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return agendamentoRepository.findByClienteAndData(cliente, data);
    }

    public List<AgendamentoModel> buscarPorClienteEProcedimento(Integer clienteId, String procedimento) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return agendamentoRepository.findByClienteAndProcedimentoContaining(cliente, procedimento);
    }

    public AgendamentoModel atualizarAgendamento(Integer clienteId, Integer agendamentoId, AgendamentoEntity agendamentoAtualizado) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        AgendamentoModel agendamentoExistente = agendamentoRepository.findByIdAndCliente(agendamentoId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com o ID " + agendamentoId + " não encontrado para o cliente " + clienteId));

        PacienteModel paciente = pacienteRepository.findById(agendamentoAtualizado.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + agendamentoAtualizado.getPacienteId()));

        agendamentoExistente.setPaciente(paciente);
        agendamentoExistente.setData(agendamentoAtualizado.getData());
        agendamentoExistente.setProcedimento(agendamentoAtualizado.getProcedimento());

        return agendamentoRepository.save(agendamentoExistente);
    }

    public void removerAgendamento(Integer clienteId, Integer agendamentoId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        AgendamentoModel agendamento = agendamentoRepository.findByIdAndCliente(agendamentoId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com o ID " + agendamentoId + " não encontrado para o cliente " + clienteId));
        agendamentoRepository.delete(agendamento);
    }
}
