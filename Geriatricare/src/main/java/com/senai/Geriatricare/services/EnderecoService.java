package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void criarEndereco(EnderecoModel enderecoModel){
        EnderecoEntity enderecoEntity = enderecoModel.toEntity();
        enderecoRepository.save(enderecoEntity);
    }

    public void atualizarEndereco(EnderecoModel enderecoModel){
        EnderecoEntity endereco = enderecoRepository.findById(enderecoModel.getId())
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + enderecoModel.getId()));

        EnderecoEntity atualizado = enderecoModel.toEntity();
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

    public List<EnderecoEntity> listarTodos(){
        return enderecoRepository.findAll();
    }

    public EnderecoEntity buscarPorId(int id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com o ID: " + id));
    }

    public EnderecoEntity buscarPorCliente(int clienteId){
        EnderecoEntity endereco = enderecoRepository.findByCliente(clienteId);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o cliente ID: " + clienteId);
        }
        return endereco;
    }

    public EnderecoEntity buscarPorFamiliar(int clienteId, int familiarId){
        EnderecoEntity endereco = enderecoRepository.findByFamiliar(clienteId, familiarId);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o familiar ID: " + familiarId);
        }
        return endereco;
    }

    public EnderecoEntity buscarPorFuncionario(int clienteId, int funcionarioId){
        EnderecoEntity endereco = enderecoRepository.findByFuncionario(clienteId, funcionarioId);
        if (endereco == null) {
            throw new EntityNotFoundException("Endereço não encontrado para o funcionário ID: " + funcionarioId);
        }
        return endereco;
    }

    public List<EnderecoEntity> buscarPorUF(String uf){
        return enderecoRepository.findByUF(uf);
    }

    public List<EnderecoEntity> buscarPorCidade(String cidade){
        return enderecoRepository.findByCidade(cidade);
    }
}