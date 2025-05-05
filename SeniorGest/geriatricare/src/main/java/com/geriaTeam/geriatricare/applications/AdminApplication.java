package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.entities.Admin;
import com.geriaTeam.geriatricare.entities.Login;
import com.geriaTeam.geriatricare.entities.Senha;
import com.geriaTeam.geriatricare.models.AdminModels;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminApplication {
    private AdminRepository adminRepository;

    @Autowired
    public AdminApplication(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void adicionarAdmin(AdminModels model) {
        Login login = new Login(model.getLogin().toString());
        Senha senha = new Senha(model.getSenha().toString());

        if (!login.validarLogin()) {
            throw new IllegalArgumentException("Login inválido. Utilize um e-mail válido.");
        }

        if (!senha.validarSenha()) {
            throw new IllegalArgumentException("Senha fraca. Deve conter no mínimo 8 caracteres, letras e números.");
        }

        Admin admin = new Admin();
        admin.setId(model.getId());
        admin.setNome(model.getNome());
        admin.setLogin(login);
        admin.setSenha(senha);

        adminRepository.adicionarAdmin(admin.toModel());
    }

    public AdminModels autenticarAdmin(String loginInput, String senhaInput) {
        List<AdminModels> admins = adminRepository.buscarAdmin();

        for (AdminModels model : admins) {
            if (model.getLogin().equals(loginInput) && model.getSenha().equals(senhaInput)) {
                return model;
            }
        }

        throw new SecurityException("Login ou senha inválidos.");
    }

    public void atualizarAdmin(AdminModels model) {
        AdminModels existente = adminRepository.buscarAdminId(model.getId());
        if (existente == null) {
            throw new EntityNotFoundException("Administrador não encontrado.");
        }
        adminRepository.atualizarAdmin(model);
    }

    public void removerAdmin(int id) {
        List<AdminModels> admins = adminRepository.buscarAdmin();
        if (admins.size() == 1) {
            throw new IllegalStateException("Não é possível remover o único administrador do sistema.");
        }

        adminRepository.removerAdmin(id);
    }

    public List<AdminModels> buscarAdmin() {
        return adminRepository.buscarAdmin();
    }

    public AdminModels buscarAdminId(int id) {
        AdminModels admin = adminRepository.buscarAdminId(id);
        if (admin == null) {
            throw new EntityNotFoundException("Administrador não encontrado.");
        }
        return admin;
    }
}
