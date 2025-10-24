package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.entities.ClienteEntity;
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

    public void criarCliente(ClienteEntity clienteEntity) {
        String cnpj = clienteEntity.getCnpj().getCnpj();
        
        if (clienteRepository.existsByCnpj(cnpj)) {
            throw new IllegalArgumentException("Já existe um cliente com o CNPJ: " + cnpj);
        }

        AdminModel admin = adminRepository.findById(clienteEntity.getAdminId())
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com o ID: " + clienteEntity.getAdminId()));

        ClienteModelModel cliente = clienteEntity.toEntity(admin);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(ClienteEntity clienteAtualizado) {
        String cnpjAtualizado = clienteAtualizado.getCnpj().getCnpj();
        String emailAtualizado = clienteAtualizado.getEmail().getEmail();
        String telefoneAtualizado = clienteAtualizado.getTelefone().getTelefone();
        
        ClienteModelModel cliente = clienteRepository.findById(clienteAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteAtualizado.getId()));

        if (!cliente.getCnpj().equals(cnpjAtualizado) &&
                clienteRepository.existsByCnpj(cnpjAtualizado)) {
            throw new IllegalArgumentException("Já existe um cliente com o CNPJ: " + cnpjAtualizado);
        }

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(emailAtualizado);
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

    public List<ClienteModelModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteModelModel buscarPorId(int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    public ClienteModelModel buscarPorEmail(String email) {
        ClienteModelModel cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o email: " + email);
        }
        return cliente;
    }

    public ClienteModelModel buscarPorCnpj(String cnpj) {
        ClienteModelModel cliente = clienteRepository.findByCnpj(cnpj);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o CNPJ: " + cnpj);
        }
        return cliente;
    }

    public ClienteModelModel buscarPorNome(String nome) {
        ClienteModelModel cliente = clienteRepository.findByNome(nome);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o nome: " + nome);
        }
        return cliente;
    }
}
