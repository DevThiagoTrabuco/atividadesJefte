package com.senai.Geriatricare.services;

import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.models.ClienteModel;
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

    public void criarFuncionario(Integer clienteId, FuncionarioEntity funcionarioEntity) {
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

        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioEntity.toEntity(cliente);
        funcionarioRepository.save(funcionario);
    }

    public void atualizarFuncionario(Integer clienteId, Integer funcionarioId, FuncionarioEntity funcionarioAtualizado) {
        String cpfAtualizado = funcionarioAtualizado.getCpf().getCpf();
        String emailAtualizado = funcionarioAtualizado.getEmail().getEmail();
        String rgAtualizado = funcionarioAtualizado.getRg().getRg();

        FuncionarioModel funcionario = funcionarioRepository.findByIdAndClienteId(funcionarioId, clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId + " para o cliente com ID: " + clienteId));

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

    public void removerFuncionario(Integer clienteId, Integer funcionarioId) {
        FuncionarioModel funcionario = funcionarioRepository.findByIdAndClienteId(funcionarioId, clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId + " para o cliente com ID: " + clienteId));
        funcionarioRepository.delete(funcionario);
    }

    public List<FuncionarioModel> findAllByCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return funcionarioRepository.findAllByCliente(cliente);
    }

    public FuncionarioModel findByIdAndClienteId(Integer funcionarioId, Integer clienteId) {
        return funcionarioRepository.findByIdAndClienteId(funcionarioId, clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário com ID " + funcionarioId + " não encontrado para o cliente com ID " + clienteId));
    }

    public FuncionarioModel buscarPorEmail(int clienteId, String email) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findByClienteAndEmail(cliente, email);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o e-mail: " + email);
        }
        return funcionario;
    }

    public FuncionarioModel buscarPorCpf(int clienteId, String cpf) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findByClienteAndCpf(cliente, cpf);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o CPF: " + cpf);
        }
        return funcionario;
    }

    public List<FuncionarioModel> buscarPorNome(int clienteId, String nome) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return funcionarioRepository.findByClienteAndNomeContaining(cliente, nome);
    }

    public List<FuncionarioModel> buscarPorFuncao(int clienteId, Funcao funcao) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return funcionarioRepository.findByClienteAndFuncao(cliente, funcao);
    }
}
