package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModel;
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

        ClienteModel cliente = clienteEntity.toEntity(admin);
        clienteRepository.save(cliente);
    }

    public void atualizarCliente(ClienteEntity clienteAtualizado) {
        String cnpjAtualizado = clienteAtualizado.getCnpj().getCnpj();
        String emailAtualizado = clienteAtualizado.getEmail().getEmail();
        String telefoneAtualizado = clienteAtualizado.getTelefone().getTelefone();
        
        ClienteModel cliente = clienteRepository.findById(clienteAtualizado.getId())
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

    public List<ClienteModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteModel buscarPorId(int id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    public ClienteModel buscarPorEmail(String email) {
        ClienteModel cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o email: " + email);
        }
        return cliente;
    }

    public ClienteModel buscarPorCnpj(String cnpj) {
        ClienteModel cliente = clienteRepository.findByCnpj(cnpj);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o CNPJ: " + cnpj);
        }
        return cliente;
    }

    public ClienteModel buscarPorNome(String nome) {
        ClienteModel cliente = clienteRepository.findByNome(nome);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado com o nome: " + nome);
        }
        return cliente;
    }
}
