package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ConsultaEntity;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ConsultaModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ConsultaRepository;
import com.senai.Geriatricare.repositories.FuncionarioRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ConsultaModel criarConsulta(ConsultaEntity consultaEntity) {
        ClienteModel cliente = clienteRepository.findById(consultaEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + consultaEntity.getClienteId()));
        PacienteModel paciente = pacienteRepository.findById(consultaEntity.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + consultaEntity.getPacienteId()));
        FuncionarioModel funcionario = funcionarioRepository.findById(consultaEntity.getFuncionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + consultaEntity.getFuncionarioId()));

        ConsultaModel consulta = consultaEntity.toModel(cliente, paciente, funcionario);
        return consultaRepository.save(consulta);
    }

    public ConsultaModel buscarPorClienteEId(Integer clienteId, Integer consultaId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return consultaRepository.findByIdAndCliente(consultaId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Consulta com o ID " + consultaId + " não encontrada para o cliente " + clienteId));
    }

    public List<ConsultaModel> buscarPorCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return consultaRepository.findByCliente(cliente);
    }

    public List<ConsultaModel> buscarPorClienteEPaciente(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return consultaRepository.findByClienteAndPaciente(cliente, paciente);
    }

    public List<ConsultaModel> buscarPorClienteEFuncionario(Integer clienteId, Integer funcionarioId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId));
        return consultaRepository.findByClienteAndFuncionario(cliente, funcionario);
    }

    public ConsultaModel atualizarConsulta(Integer consultaId, Integer clienteId, ConsultaEntity consultaAtualizada) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        ConsultaModel consultaExistente = consultaRepository.findByIdAndCliente(consultaId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Consulta com o ID " + consultaId + " não encontrada para o cliente " + clienteId));

        PacienteModel paciente = pacienteRepository.findById(consultaAtualizada.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + consultaAtualizada.getPacienteId()));
        FuncionarioModel funcionario = funcionarioRepository.findById(consultaAtualizada.getFuncionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + consultaAtualizada.getFuncionarioId()));

        consultaExistente.setPaciente(paciente);
        consultaExistente.setFuncionario(funcionario);
        consultaExistente.setDataConsulta(consultaAtualizada.getDataConsulta());
        consultaExistente.setObservacoes(consultaAtualizada.getObservacoes());

        return consultaRepository.save(consultaExistente);
    }

    public void removerConsulta(Integer consultaId, Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        ConsultaModel consulta = consultaRepository.findByIdAndCliente(consultaId, cliente)
                .orElseThrow(() -> new EntityNotFoundException("Consulta com o ID " + consultaId + " não encontrada para o cliente " + clienteId));
        consultaRepository.delete(consulta);
    }
}
