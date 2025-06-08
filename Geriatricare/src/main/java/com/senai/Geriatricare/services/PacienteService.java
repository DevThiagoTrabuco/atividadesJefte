package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final ClienteService clienteService;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ClienteService clienteService) {
        this.pacienteRepository = pacienteRepository;
        this.clienteService = clienteService;
    }

    public void criarPaciente(PacienteModel pacienteModel) {
        String cpf = pacienteModel.getCpf().getCpf();
        String rg = pacienteModel.getRg().getRg();

        if (pacienteRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um paciente com o CPF: " + cpf);
        }
        if (pacienteRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um paciente com o RG: " + rg);
        }

        ClienteEntity cliente = clienteService.buscarPorId(pacienteModel.getClienteId());
        PacienteEntity paciente = pacienteModel.toEntity(cliente);
        pacienteRepository.save(paciente);
    }

    public void atualizarPaciente(PacienteModel pacienteAtualizado) {
        String cpfAtualizado = pacienteAtualizado.getCpf().getCpf();
        String rgAtualizado = pacienteAtualizado.getRg().getRg();

        PacienteEntity paciente = pacienteRepository.findById(pacienteAtualizado.getId())
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

    public List<PacienteEntity> listarTodos() {
        return pacienteRepository.findAll();
    }

    public PacienteEntity buscarPorId(int id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente com ID " + id + " não encontrado."));
    }

    public PacienteEntity buscarPorNome(int clienteId, String nome) {
        PacienteEntity paciente = pacienteRepository.findByNome(clienteId, nome);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o nome: " + nome);
        }
        return paciente;
    }

    public PacienteEntity buscarPorCpf(String cpf) {
        PacienteEntity paciente = pacienteRepository.findByCpf(cpf);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o CPF: " + cpf);
        }
        return paciente;
    }

    public PacienteEntity buscarPorRg(String rg) {
        PacienteEntity paciente = pacienteRepository.findByRg(rg);
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado com o RG: " + rg);
        }
        return paciente;
    }

    public List<PacienteEntity> buscarPorFamiliar(int clienteId, int familiarId) {
        return pacienteRepository.findByFamiliar(clienteId, familiarId);
    }

    public List<PacienteEntity> buscarPorStatusPaciente(int clienteId, StatusPaciente statusPaciente) {
        return pacienteRepository.findByStatusPaciente(clienteId, statusPaciente.name());
    }

    public List<PacienteEntity> buscarPorGenero(int clienteId, Genero genero) {
        return pacienteRepository.findByGenero(clienteId, genero.name());
    }

    public List<PacienteEntity> buscarPorPlano(int clienteId, String plano) {
        return pacienteRepository.findByPlano(clienteId, plano);
    }
}