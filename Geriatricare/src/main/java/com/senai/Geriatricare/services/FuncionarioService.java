package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository, ClienteRepository clienteRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
    }

    public void criarFuncionario(FuncionarioEntity funcionarioEntity) {
        String cpf = funcionarioEntity.getCpf().getCpf();
        String email = funcionarioEntity.getEmail().getEmail();
        String rg = funcionarioEntity.getRg().getRg();

        if (funcionarioRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um funcionário com o CPF: " + cpf);
        }
        if (funcionarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um funcionário com o e-mail: " + email);
        }
        if (funcionarioRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um funcionário com o RG: " + rg);
        }

        ClienteModelModel cliente = clienteRepository.findById(funcionarioEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + funcionarioEntity.getClienteId()));
        FuncionarioModel funcionario = funcionarioEntity.toEntity(cliente);
        funcionarioRepository.save(funcionario);
    }

    public void atualizarFuncionario(FuncionarioEntity funcionarioAtualizado) {
        String cpfAtualizado = funcionarioAtualizado.getCpf().getCpf();
        String emailAtualizado = funcionarioAtualizado.getEmail().getEmail();
        String rgAtualizado = funcionarioAtualizado.getRg().getRg();

        FuncionarioModel funcionario = funcionarioRepository.findById(funcionarioAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioAtualizado.getId()));

        if (!funcionario.getCpf().equals(cpfAtualizado) && funcionarioRepository.existsByCpf(cpfAtualizado)) {
            throw new IllegalArgumentException("Já existe um funcionário com o CPF: " + cpfAtualizado);
        }
        if (!funcionario.getEmail().equals(emailAtualizado) && funcionarioRepository.existsByEmail(emailAtualizado)) {
            throw new IllegalArgumentException("Já existe um funcionário com o e-mail: " + emailAtualizado);
        }
        if (!funcionario.getRg().equals(rgAtualizado) && funcionarioRepository.existsByRg(rgAtualizado)) {
            throw new IllegalArgumentException("Já existe um funcionário com o RG: " + rgAtualizado);
        }

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setEmail(emailAtualizado);
        funcionario.setTelefone(funcionarioAtualizado.getTelefone().getTelefone());
        funcionario.setCpf(cpfAtualizado);
        funcionario.setRg(rgAtualizado);
        funcionario.setDataNascimento(funcionarioAtualizado.getDataNascimento());
        funcionario.setFuncao(funcionarioAtualizado.getFuncao());
        funcionario.setEndereco(funcionarioAtualizado.getEndereco().toEntity());

        funcionarioRepository.save(funcionario);
    }

    public void removerFuncionario(int id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Funcionário não encontrado com o ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    public List<FuncionarioModel> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel buscarPorId(int id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário com ID " + id + " não encontrado."));
    }

    public FuncionarioModel buscarPorEmail(int clienteId, String email) {
        ClienteModelModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findByClienteAndEmail(cliente, email);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o e-mail: " + email);
        }
        return funcionario;
    }

    public FuncionarioModel buscarPorCpf(int clienteId, String cpf) {
        ClienteModelModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findByClienteAndCpf(cliente, cpf);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o CPF: " + cpf);
        }
        return funcionario;
    }

    public FuncionarioModel buscarPorNome(int clienteId, String nome) {
        ClienteModelModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findByClienteAndNome(cliente, nome);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o nome: " + nome);
        }
        return funcionario;
    }

    public List<FuncionarioModel> buscarPorFuncao(int clienteId, String funcao) {
        ClienteModelModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return funcionarioRepository.findByClienteAndFuncao(cliente, funcao);
    }
}