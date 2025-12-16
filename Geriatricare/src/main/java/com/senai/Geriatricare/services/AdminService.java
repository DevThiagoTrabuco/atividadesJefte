package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.entities.AdminEntity;
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

    public void criarAdmin(AdminEntity adminEntity) {
        String email = adminEntity.getEmail().getEmail();

        if (adminRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um admin com o email: " + email);
        }

        AdminModel admin = adminEntity.toModel();

        if (admin.getEmail() == null) {
            throw new IllegalArgumentException("Email inválido.");
        }


        adminRepository.save(admin);
    }

    public void atualizarAdmin(AdminEntity adminAtualizado) {
        AdminModel admin = adminRepository.findById(adminAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com o ID: " + adminAtualizado.getId()));

        String emailAtualizado = adminAtualizado.getEmail().getEmail();
        if (adminRepository.existsByEmail(emailAtualizado) && !admin.getEmail().equals(emailAtualizado)) {
            throw new IllegalArgumentException("Já existe um admin com o email: " + emailAtualizado);
        }

        AdminModel adminConvertido = adminAtualizado.toModel();

        if (adminConvertido.getEmail() == null) {
            throw new IllegalArgumentException("Email inválido.");
        }

        admin.setNome(adminConvertido.getNome());
        admin.setEmail(adminConvertido.getEmail());

        adminRepository.save(admin);
    }

    public void removerAdmin(int id) {
        if (!adminRepository.existsById(id)) {
            throw new EntityNotFoundException("Admin não encontrado com o ID: " + id);
        }
        adminRepository.deleteById(id);
    }

    public List<AdminModel> listarTodos() {
        return adminRepository.findAll();
    }

    public AdminModel buscarPorId(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public AdminModel buscarPorEmail(String email) {
        AdminModel admin = adminRepository.findByEmail(email);
        if (admin == null) {
            throw new EntityNotFoundException("Admin não encontrado com o email: " + email);
        }
        return admin;
    }

    public AdminModel buscarPorNome(String nome) {
        AdminModel admin = adminRepository.findByNome(nome);
        if (admin == null) {
            throw new EntityNotFoundException("Admin não encontrado com o nome: " + nome);
        }
        return admin;
    }
}
