package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.models.FuncionarioModel;
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

    public void criarFuncionario(FuncionarioModel funcionarioModel) {
        String cpf = funcionarioModel.getCpf().getCpf();
        String email = funcionarioModel.getEmail().getEmail();
        String rg = funcionarioModel.getRg().getRg();

        if (funcionarioRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("Já existe um funcionário com o CPF: " + cpf);
        }
        if (funcionarioRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um funcionário com o e-mail: " + email);
        }
        if (funcionarioRepository.existsByRg(rg)) {
            throw new IllegalArgumentException("Já existe um funcionário com o RG: " + rg);
        }

        ClienteEntity cliente = clienteRepository.findById(funcionarioModel.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + funcionarioModel.getClienteId()));
        FuncionarioEntity funcionario = funcionarioModel.toEntity(cliente);
        funcionarioRepository.save(funcionario);
    }

    public void atualizarFuncionario(FuncionarioModel funcionarioAtualizado) {
        String cpfAtualizado = funcionarioAtualizado.getCpf().getCpf();
        String emailAtualizado = funcionarioAtualizado.getEmail().getEmail();
        String rgAtualizado = funcionarioAtualizado.getRg().getRg();

        FuncionarioEntity funcionario = funcionarioRepository.findById(funcionarioAtualizado.getId())
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
        funcionario.setSenha(funcionarioAtualizado.getSenha().getSenha());
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

    public List<FuncionarioEntity> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioEntity buscarPorId(int id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário com ID " + id + " não encontrado."));
    }

    public FuncionarioEntity buscarPorEmail(int clienteId, String email) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioEntity funcionario = funcionarioRepository.findByClienteAndEmail(cliente, email);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o e-mail: " + email);
        }
        return funcionario;
    }

    public FuncionarioEntity buscarPorCpf(int clienteId, String cpf) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioEntity funcionario = funcionarioRepository.findByClienteAndCpf(cliente, cpf);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o CPF: " + cpf);
        }
        return funcionario;
    }

    public FuncionarioEntity buscarPorNome(int clienteId, String nome) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioEntity funcionario = funcionarioRepository.findByClienteAndNome(cliente, nome);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com o nome: " + nome);
        }
        return funcionario;
    }

    public List<FuncionarioEntity> buscarPorFuncao(int clienteId, String funcao) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return funcionarioRepository.findByClienteAndFuncao(cliente, funcao);
    }
}