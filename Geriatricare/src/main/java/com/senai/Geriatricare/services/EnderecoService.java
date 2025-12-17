package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.EnderecoRepository;
import com.senai.Geriatricare.repositories.FamiliarRepository;
import com.senai.Geriatricare.repositories.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;
    private final FamiliarRepository familiarRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository,
                           ClienteRepository clienteRepository,
                           FamiliarRepository familiarRepository,
                           FuncionarioRepository funcionarioRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
        this.familiarRepository = familiarRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void criarEndereco(EnderecoEntity enderecoEntity){
        EnderecoModel enderecoModel = enderecoEntity.toModel();
        enderecoRepository.save(enderecoModel);
    }

    public void atualizarEndereco(EnderecoEntity enderecoEntity){
        EnderecoModel endereco = enderecoRepository.findById(enderecoEntity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + enderecoEntity.getId()));

        EnderecoModel atualizado = enderecoEntity.toModel();
        endereco.setLogradouro(atualizado.getLogradouro());
        endereco.setNumero(atualizado.getNumero());
        endereco.setBairro(atualizado.getBairro());
        endereco.setCidade(atualizado.getCidade());
        endereco.setUnidadeFederativa(atualizado.getUnidadeFederativa());
        endereco.setCep(atualizado.getCep());
        endereco.setComplemento(atualizado.getComplemento());

        enderecoRepository.save(endereco);
    }

    public void removerEndereco(int id){
        if (!enderecoRepository.existsById(id)) {
            throw new EntityNotFoundException("Endereço não encontrado com o ID: " + id);
        }
        enderecoRepository.deleteById(id);
    }

    public List<EnderecoModel> listarTodos(){
        return enderecoRepository.findAll();
    }

    public EnderecoModel buscarPorId(int id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + id));
    }

    public EnderecoModel buscarPorCliente(int clienteId){
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        EnderecoModel endereco = enderecoRepository.findByCliente(cliente);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o cliente ID: " + clienteId);
        }
        return endereco;
    }

    public EnderecoModel buscarPorFamiliar(int clienteId, int familiarId){
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FamiliarModel familiar = familiarRepository.findById(familiarId)
                .orElseThrow(() -> new EntityNotFoundException("Familiar não encontrado com o ID: " + familiarId));
        EnderecoModel endereco = enderecoRepository.findByClienteAndFamiliar(cliente, familiar);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o familiar ID: " + familiarId);
        }
        return endereco;
    }

    public EnderecoModel buscarPorFuncionario(int clienteId, int funcionarioId){
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        FuncionarioModel funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com o ID: " + funcionarioId));
        EnderecoModel endereco = enderecoRepository.findByClienteAndFuncionario(cliente, funcionario);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o funcionário ID: " + funcionarioId);
        }
        return endereco;
    }

    public List<EnderecoModel> buscarPorUnidadeFederativa(UnidadeFederativa uf){
        return enderecoRepository.findByUnidadeFederativa(uf);
    }

    public List<EnderecoModel> buscarPorCidade(String cidade){
        return enderecoRepository.findByCidade(cidade);
    }
}