package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.FamiliarRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarService {
    private final FamiliarRepository familiarRepository;
    private final ClienteRepository clienteRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public FamiliarService(FamiliarRepository familiarRepository, ClienteRepository clienteRepository, PacienteRepository pacienteRepository) {
        this.familiarRepository = familiarRepository;
        this.clienteRepository = clienteRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public void criarFamiliar(FamiliarEntity familiarEntity) {
        String cpf = familiarEntity.getCpf().getCpf();
        String email = familiarEntity.getEmail().getEmail();
        String rg = familiarEntity.getRg().getRg();

        if (familiarRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um familiar com o CPF: " + cpf);
        }
        if (familiarRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um familiar com o e-mail: " + email);
        }
        if (familiarRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um familiar com o RG: " + rg);
        }

        ClienteModel cliente = clienteRepository.findById(familiarEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + familiarEntity.getClienteId()));

        FamiliarModel familiar = familiarEntity.toEntity(cliente);
        familiarRepository.save(familiar);
    }

    public void atualizarFamiliar(FamiliarEntity familiarAtualizado) {
        String cpfAtualizado = familiarAtualizado.getCpf().getCpf();
        String emailAtualizado = familiarAtualizado.getEmail().getEmail();
        String rgAtualizado = familiarAtualizado.getRg().getRg();

        FamiliarModel familiar = familiarRepository.findById(familiarAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Familiar não encontrado com o ID: " + familiarAtualizado.getId()));

        if (!familiar.getCpf().equals(cpfAtualizado) && familiarRepository.existsByCpf(cpfAtualizado)) {
            throw new IllegalArgumentException("Já existe um familiar com o CPF: " + cpfAtualizado);
        }
        if (!familiar.getEmail().equals(emailAtualizado) && familiarRepository.existsByEmail(emailAtualizado)) {
            throw new IllegalArgumentException("Já existe um familiar com o e-mail: " + emailAtualizado);
        }
        if (!familiar.getRg().equals(rgAtualizado) && familiarRepository.existsByRg(rgAtualizado)) {
            throw new IllegalArgumentException("Já existe um familiar com o RG: " + rgAtualizado);
        }

        familiar.setNome(familiarAtualizado.getNome());
        familiar.setEmail(emailAtualizado);
        familiar.setTelefone(familiarAtualizado.getTelefone().getTelefone());
        familiar.setCpf(cpfAtualizado);
        familiar.setRg(rgAtualizado);
        familiar.setParentesco(familiarAtualizado.getParentesco());
        familiar.setEndereco(familiarAtualizado.getEndereco().toEntity());

        familiarRepository.save(familiar);
    }

    public void removerFamiliar(int id) {
        if (!familiarRepository.existsById(id)) {
            throw new EntityNotFoundException("Familiar não encontrado com o ID: " + id);
        }
        familiarRepository.deleteById(id);
    }

    public List<FamiliarModel> listarTodos() {
        return familiarRepository.findAll();
    }

    public FamiliarModel buscarPorId(int id) {
        return familiarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Familiar com ID " + id + " não encontrado."));
    }

    public FamiliarModel buscarPorNome(int clienteId, String nome) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findByClienteAndNome(cliente, nome);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o nome: " + nome);
        }
        return familiar;
    }

    public FamiliarModel buscarPorEmail(int clienteId, String email) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findByClienteAndEmail(cliente, email);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o e-mail: " + email);
        }
        return familiar;
    }

    public FamiliarModel buscarPorCpf(int clienteId, String cpf) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findByClienteAndCpf(cliente, cpf);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o CPF: " + cpf);
        }
        return familiar;
    }

    public FamiliarModel buscarPorRg(int clienteId, String rg) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findByClienteAndRg(cliente, rg);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o RG: " + rg);
        }
        return familiar;
    }

    public List<FamiliarModel> buscarPorPaciente(int clienteId, int pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return familiarRepository.findByClienteAndPacientes(cliente, paciente);
    }
}