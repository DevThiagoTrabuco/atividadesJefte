package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.repositories.AdminRepository;
import com.senai.Geriatricare.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, AdminRepository adminRepository) {
        this.clienteRepository = clienteRepository;
        this.adminRepository = adminRepository;
    }

    public void criarCliente(ClienteModel clienteModel) {
        String cnpj = clienteModel.getCnpj().getCnpj();
        
        if (clienteRepository.existsByCnpj(cnpj)) {
            throw new IllegalArgumentException("Já existe um cliente com o CNPJ: " + cnpj);
        }

        AdminEntity admin = adminRepository.findById(clienteModel.getAdminId())
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com o ID: " + clienteModel.getAdminId()));

        ClienteEntity cliente = clienteModel.toEntity(admin);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(ClienteModel clienteAtualizado) {
        String cnpjAtualizado = clienteAtualizado.getCnpj().getCnpj();
        String emailAtualizado = clienteAtualizado.getEmail().getEmail();
        String telefoneAtualizado = clienteAtualizado.getTelefone().getTelefone();
        String senhaAtualizada = clienteAtualizado.getSenha().getSenha();
        
        ClienteEntity cliente = clienteRepository.findById(clienteAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteAtualizado.getId()));

        if (!cliente.getCnpj().equals(cnpjAtualizado) &&
                clienteRepository.existsByCnpj(cnpjAtualizado)) {
            throw new IllegalArgumentException("Já existe um cliente com o CNPJ: " + cnpjAtualizado);
        }

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(emailAtualizado);
        cliente.setSenha(senhaAtualizada);
        cliente.setTelefone(telefoneAtualizado);
        cliente.setCnpj(cnpjAtualizado);
        cliente.setEndereco(clienteAtualizado.getEndereco().toEntity());

        clienteRepository.save(cliente);
    }

    public void removerCliente(int id) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente não encontrado com o ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    public List<ClienteEntity> listarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarPorId(int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    public ClienteEntity buscarPorEmail(String email) {
        ClienteEntity cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o email: " + email);
        }
        return cliente;
    }

    public ClienteEntity buscarPorCnpj(String cnpj) {
        ClienteEntity cliente = clienteRepository.findByCnpj(cnpj);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o CNPJ: " + cnpj);
        }
        return cliente;
    }

    public ClienteEntity buscarPorNome(String nome) {
        ClienteEntity cliente = clienteRepository.findByNome(nome);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o nome: " + nome);
        }
        return cliente;
    }

    public List<ClienteEntity> buscarPorAdmin(int adminId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com o ID: " + adminId));
        return clienteRepository.findByAdmin(admin);
    }
}
