package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.FamiliarRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final ClienteRepository clienteRepository;
    private final FamiliarRepository familiarRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ClienteRepository clienteRepository, FamiliarRepository familiarRepository) {
        this.pacienteRepository = pacienteRepository;
        this.clienteRepository = clienteRepository;
        this.familiarRepository = familiarRepository;
    }

    public void criarPaciente(PacienteEntity pacienteEntity) {
        String cpf = pacienteEntity.getCpf().getCpf();
        String rg = pacienteEntity.getRg().getRg();

        if (pacienteRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um paciente com o CPF: " + cpf);
        }
        if (pacienteRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um paciente com o RG: " + rg);
        }

        ClienteModel cliente = clienteRepository.findById(pacienteEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + pacienteEntity.getClienteId()));
        PacienteModel paciente = pacienteEntity.toEntity(cliente);
        pacienteRepository.save(paciente);
    }

    public void atualizarPaciente(PacienteEntity pacienteAtualizado) {
        String cpfAtualizado = pacienteAtualizado.getCpf().getCpf();
        String rgAtualizado = pacienteAtualizado.getRg().getRg();

        PacienteModel paciente = pacienteRepository.findById(pacienteAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteAtualizado.getId()));

        if (!paciente.getCpf().equals(cpfAtualizado) && pacienteRepository.existsByCpf(cpfAtualizado)) {
            throw new IllegalArgumentException("Já existe um paciente com o CPF: " + cpfAtualizado);
        }
        if (!paciente.getRg().equals(rgAtualizado) && pacienteRepository.existsByRg(rgAtualizado)) {
            throw new IllegalArgumentException("Já existe um paciente com o RG: " + rgAtualizado);
        }

        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(cpfAtualizado);
        paciente.setRg(rgAtualizado);
        paciente.setEmail(pacienteAtualizado.getEmail().getEmail());
        paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        paciente.setPlano(pacienteAtualizado.getPlano());
        paciente.setGenero(pacienteAtualizado.getGenero());
        paciente.setStatusPaciente(pacienteAtualizado.getStatusPaciente());

        pacienteRepository.save(paciente);
    }

    public void removerPaciente(int id) {
        if (!pacienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Paciente não encontrado com o ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    public List<PacienteModel> listarTodos() {
        return pacienteRepository.findAll();
    }

    public PacienteModel buscarPorId(int id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente com ID " + id + " não encontrado."));
    }

    public PacienteModel buscarPorNome(int clienteId, String nome) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findByClienteAndNome(cliente, nome);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o nome: " + nome);
        }
        return paciente;
    }

    public PacienteModel buscarPorCpf(int clienteId, String cpf) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findByClienteAndCpf(cliente, cpf);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o CPF: " + cpf);
        }
        return paciente;
    }

    public PacienteModel buscarPorRg(int clienteId, String rg) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findByClienteAndRg(cliente, rg);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o RG: " + rg);
        }
        return paciente;
    }

    public List<PacienteModel> buscarPorFamiliar(int clienteId, int familiarId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findById(familiarId)
                .orElseThrow(() -> new EntityNotFoundException("Familiar não encontrado com o ID: " + familiarId));
        return pacienteRepository.findByClienteAndFamiliares(cliente, familiar);
    }

    public List<PacienteModel> buscarPorStatusPaciente(int clienteId, StatusPaciente statusPaciente) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return pacienteRepository.findByClienteAndStatusPaciente(cliente, statusPaciente.name());
    }

    public List<PacienteModel> buscarPorGenero(int clienteId, Genero genero) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return pacienteRepository.findByClienteAndGenero(cliente, genero.name());
    }

    public List<PacienteModel> buscarPorPlano(int clienteId, String plano) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return pacienteRepository.findByClienteAndPlano(cliente, plano);
    }
}