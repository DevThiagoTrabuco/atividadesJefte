package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.FamiliarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarService {
    private final FamiliarRepository familiarRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public FamiliarService(FamiliarRepository familiarRepository, ClienteRepository clienteRepository) {
        this.familiarRepository = familiarRepository;
        this.clienteRepository = clienteRepository;
    }

    public void criarFamiliar(FamiliarModel familiarModel) {
        String cpf = familiarModel.getCpf().getCpf();
        String email = familiarModel.getEmail().getEmail();
        String rg = familiarModel.getRg().getRg();

        if (familiarRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um familiar com o CPF: " + cpf);
        }
        if (familiarRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um familiar com o e-mail: " + email);
        }
        if (familiarRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um familiar com o RG: " + rg);
        }

        ClienteEntity cliente = clienteRepository.findById(familiarModel.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + familiarModel.getClienteId()));

        FamiliarEntity familiar = familiarModel.toEntity(cliente);
        familiarRepository.save(familiar);
    }

    public void atualizarFamiliar(FamiliarModel familiarAtualizado) {
        String cpfAtualizado = familiarAtualizado.getCpf().getCpf();
        String emailAtualizado = familiarAtualizado.getEmail().getEmail();
        String rgAtualizado = familiarAtualizado.getRg().getRg();

        FamiliarEntity familiar = familiarRepository.findById(familiarAtualizado.getId())
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
        familiar.setSenha(familiarAtualizado.getSenha().getSenha());
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

    public List<FamiliarEntity> listarTodos() {
        return familiarRepository.findAll();
    }

    public FamiliarEntity buscarPorId(int id) {
        return familiarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Familiar com ID " + id + " não encontrado."));
    }

    public FamiliarEntity buscarPorNome(int clienteId, String nome) {
        FamiliarEntity familiar = familiarRepository.findByNome(clienteId, nome);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o nome: " + nome);
        }
        return familiar;
    }

    public FamiliarEntity buscarPorEmail(int clienteId, String email) {
        FamiliarEntity familiar = familiarRepository.findByEmail(clienteId, email);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o e-mail: " + email);
        }
        return familiar;
    }

    public FamiliarEntity buscarPorCpf(int clienteId, String cpf) {
        FamiliarEntity familiar = familiarRepository.findByCpf(clienteId, cpf);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o CPF: " + cpf);
        }
        return familiar;
    }

    public FamiliarEntity buscarPorRg(int clienteId, String rg) {
        FamiliarEntity familiar = familiarRepository.findByRg(clienteId, rg);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado com o RG: " + rg);
        }
        return familiar;
    }

    public List<FamiliarEntity> buscarPorPaciente(int clienteId, int pacienteId) {
        return familiarRepository.findByPaciente(clienteId, pacienteId);
    }
}