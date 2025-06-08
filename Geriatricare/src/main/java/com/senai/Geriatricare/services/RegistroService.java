package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.entities.RegistroEntity;
import com.senai.Geriatricare.models.RegistroModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.FuncionarioRepository;
import com.senai.Geriatricare.repositories.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroService {
    private final RegistroRepository registroRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public RegistroService(RegistroRepository registroRepository, ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository) {
        this.registroRepository = registroRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void criarRegistro(RegistroModel registroModel) {
        ClienteEntity cliente = clienteRepository.findById(registroModel.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + registroModel.getClienteId()));
        FuncionarioEntity funcionario = funcionarioRepository.findById(registroModel.getFuncionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + registroModel.getFuncionarioId()));
        RegistroEntity registro = registroModel.toEntity(cliente, funcionario);
        registroRepository.save(registro);
    }

    public void atualizarRegistro(RegistroModel registroAtualizado) {
        RegistroEntity registro = registroRepository.findById(registroAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado com o ID: " + registroAtualizado.getId()));

        ClienteEntity cliente = clienteRepository.findById(registroAtualizado.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + registroAtualizado.getClienteId()));
        FuncionarioEntity funcionario = funcionarioRepository.findById(registroAtualizado.getFuncionarioId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + registroAtualizado.getFuncionarioId()));

        registro.setCliente(cliente);
        registro.setFuncionario(funcionario);
        registro.setEntidade(registroAtualizado.getEntidade());
        registro.setEntidadeId(registroAtualizado.getEntidadeId());
        registro.setCampo(registroAtualizado.getCampo());
        registro.setValorAntigo(registroAtualizado.getValorAntigo());
        registro.setValorNovo(registroAtualizado.getValorNovo());
        registro.setDataHora(registroAtualizado.getDataHora());

        registroRepository.save(registro);
    }

    public void removerRegistro(int id) {
        if (!registroRepository.existsById(id)) {
            throw new EntityNotFoundException("Registro não encontrado com o ID: " + id);
        }
        registroRepository.deleteById(id);
    }

    public List<RegistroEntity> listarTodos() {
        return registroRepository.findAll();
    }

    public RegistroEntity buscarPorId(int id) {
        return registroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro com ID " + id + " não encontrado."));
    }

    public List<RegistroEntity> buscarPorEntidadeEId(int clienteId, String entidade, int entidadeId) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return registroRepository.findByClienteAndEntidadeAndId(cliente, entidade, entidadeId);
    }

    public List<RegistroEntity> buscarPorEntidade(int clienteId, String entidade) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return registroRepository.findByClienteAndEntidade(cliente, entidade);
    }

    public List<RegistroEntity> buscarPorFuncionario(int clienteId, int funcionarioId) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioEntity funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId));
        return registroRepository.findByClienteAndFuncionario(cliente, funcionario);
    }

    public List<RegistroEntity> buscarPorData(int clienteId, LocalDateTime dataHora) {
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return registroRepository.findByClienteAndDataHora(cliente, dataHora);
    }
}