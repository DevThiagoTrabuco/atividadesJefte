package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.repositories.AdminRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void criarAdmin(AdminModel adminModel) {
        String email = adminModel.getEmail().getEmail();

        if (adminRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um admin com o email: " + email);
        }

        AdminEntity admin = adminModel.toEntity();

        if (admin.getEmail() == null) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (admin.getSenha() == null) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        adminRepository.save(admin);
    }

    public void atualizarAdmin(AdminModel adminAtualizado) {
        AdminEntity admin = adminRepository.findById(adminAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com o ID: " + adminAtualizado.getId()));

        String emailAtualizado = adminAtualizado.getEmail().getEmail();
        if (adminRepository.existsByEmail(emailAtualizado) && !admin.getEmail().equals(emailAtualizado)) {
            throw new IllegalArgumentException("Já existe um admin com o email: " + emailAtualizado);
        }

        AdminEntity adminConvertido = adminAtualizado.toEntity();

        if (adminConvertido.getEmail() == null) {
            throw new IllegalArgumentException("Email inválido.");
        }

        if (adminConvertido.getSenha() == null) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        admin.setNome(adminConvertido.getNome());
        admin.setEmail(adminConvertido.getEmail());
        admin.setSenha(adminConvertido.getSenha());

        adminRepository.save(admin);
    }

    public void removerAdmin(int id) {
        if (!adminRepository.existsById(id)) {
            throw new EntityNotFoundException("Admin não encontrado com o ID: " + id);
        }
        adminRepository.deleteById(id);
    }

    public List<AdminEntity> listarTodos() {
        return adminRepository.findAll();
    }

    public AdminEntity buscarPorId(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public AdminEntity buscarPorEmail(String email) {
        AdminEntity admin = adminRepository.findByEmail(email);
        if (admin == null) {
            throw new EntityNotFoundException("Admin não encontrado com o email: " + email);
        }
        return admin;
    }

    public AdminEntity buscarPorNome(String nome) {
        AdminEntity admin = adminRepository.findByNome(nome);
        if (admin == null) {
            throw new EntityNotFoundException("Admin não encontrado com o nome: " + nome);
        }
        return admin;
    }
}
