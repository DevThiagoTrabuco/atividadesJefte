package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ObservacaoEntity;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ObservacaoModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ObservacaoRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ObservacaoService {

    private final ObservacaoRepository observacaoRepository;
    private final ClienteRepository clienteRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public ObservacaoService(ObservacaoRepository observacaoRepository, ClienteRepository clienteRepository, PacienteRepository pacienteRepository) {
        this.observacaoRepository = observacaoRepository;
        this.clienteRepository = clienteRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public ObservacaoModel criarObservacao(Integer clienteId, Integer pacienteId, ObservacaoEntity observacaoEntity) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));

        ObservacaoModel observacao = observacaoEntity.toModel(cliente, paciente);
        observacao.setDataCriacao(LocalDateTime.now());

        return observacaoRepository.save(observacao);
    }

    public ObservacaoModel atualizarObservacao(Integer clienteId, Integer pacienteId, Integer observacaoId, ObservacaoEntity observacaoEntity) {
        clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));

        ObservacaoModel observacaoExistente = observacaoRepository.findById(observacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Observação não encontrada com o ID: " + observacaoId));

        observacaoExistente.setObservacao(observacaoEntity.getObservacao());

        return observacaoRepository.save(observacaoExistente);
    }

    public void removerObservacao(Integer clienteId, Integer pacienteId, Integer observacaoId) {
        clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));

        if (!observacaoRepository.existsById(observacaoId)) {
            throw new EntityNotFoundException("Observação não encontrada com o ID: " + observacaoId);
        }
        observacaoRepository.deleteById(observacaoId);
    }

    public ObservacaoModel buscarPorId(Integer clienteId, Integer pacienteId, Integer observacaoId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));

        return observacaoRepository.findByClienteAndId(cliente, observacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Observação não encontrada com o ID: " + observacaoId));
    }

    public List<ObservacaoModel> buscarPorPaciente(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return observacaoRepository.findByClienteAndPaciente(cliente, paciente);
    }
}
