package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.entities.RegistroEntity;
import com.senai.Geriatricare.models.RegistroModel;
import com.senai.Geriatricare.repositories.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroService {
    private final RegistroRepository registroRepository;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    @Autowired
    public RegistroService(RegistroRepository registroRepository, ClienteService clienteService, FuncionarioService funcionarioService) {
        this.registroRepository = registroRepository;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    public void criarRegistro(RegistroModel registroModel) {
        ClienteEntity cliente = clienteService.buscarPorId(registroModel.getClienteId());
        FuncionarioEntity funcionario = funcionarioService.buscarPorId(registroModel.getFuncionarioId());
        RegistroEntity registro = registroModel.toEntity(cliente, funcionario);
        registroRepository.save(registro);
    }

    public void atualizarRegistro(RegistroModel registroAtualizado) {
        RegistroEntity registro = registroRepository.findById(registroAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado com o ID: " + registroAtualizado.getId()));

        ClienteEntity cliente = clienteService.buscarPorId(registroAtualizado.getClienteId());
        FuncionarioEntity funcionario = funcionarioService.buscarPorId(registroAtualizado.getFuncionarioId());

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
        return registroRepository.findByEntidadeAndId(clienteId, entidade, entidadeId);
    }

    public List<RegistroEntity> buscarPorEntidade(int clienteId, String entidade) {
        return registroRepository.findByEntidade(clienteId, entidade);
    }

    public List<RegistroEntity> buscarPorFuncionario(int clienteId, int funcionarioId) {
        return registroRepository.findByFuncionario(clienteId, funcionarioId);
    }

    public List<RegistroEntity> buscarPorData(int clienteId, LocalDateTime dataHora) {
        return registroRepository.findByDate(clienteId, dataHora);
    }
}