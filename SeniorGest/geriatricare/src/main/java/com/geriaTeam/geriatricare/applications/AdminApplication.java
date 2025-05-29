package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.entities.Admin;
import com.geriaTeam.geriatricare.entities.Email;
import com.geriaTeam.geriatricare.models.AdminModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminApplication {
    private AdminRepository adminRepository;
    
    
    @Autowired
    public AdminApplication(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void adicionar(AdminModels adminModels){
        if(adminRepository.buscarPorEmail(adminModels.getEmail()) !=null){
            throw new IllegalArgumentException("Já existe um administrador com o email: " + adminModels.getEmail());
        }
        if (adminModels.getNome() == null || adminModels.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do administrador não pode ser vazio.");
        }
        if(adminModels.getSenha() == null || adminModels.getSenha().isEmpty()) {
            throw new IllegalArgumentException("A senha do administrador não pode ser vazia.");
        }
        Email email = new Email(adminModels.getEmail());

        if(!email.validarEmail()){
            throw new IllegalArgumentException("Email inválido: " + adminModels.getEmail());
        }

        Admin admin = new Admin();
        admin.setNome(adminModels.getNome());
        admin.setEmail(email);
        admin.setSenha(adminModels.getSenha());

        this.adminRepository.adicionar(admin.toModel());
    }

    public void atualizarAdmin(AdminModels adminAtualizado) {
        AdminModels adminExistente = adminRepository.buscarPorCodigo(adminAtualizado.getId());
        if (adminExistente == null) {
            throw new IllegalArgumentException("Admin com ID " + adminAtualizado.getId() + " não encontrado.");
        }

        if (adminAtualizado.getNome() != null && !adminAtualizado.getNome().isEmpty()) {
            adminExistente.setNome(adminAtualizado.getNome());
        }
        if (adminAtualizado.getSenha() != null && !adminAtualizado.getSenha().isEmpty()) {
            adminExistente.setSenha(adminAtualizado.getSenha());
        }
        if (adminAtualizado.getEmail() != null && !adminAtualizado.getEmail().isEmpty()) {
            Email email = new Email(adminAtualizado.getEmail());
            if (!email.validarEmail()) {
                throw new IllegalArgumentException("O email do administrador não é válido.");
            }
            adminExistente.setEmail(adminAtualizado.getEmail());
        }

        adminRepository.atualizar(adminExistente);
    }


    public void remover(int codigo){
        this.adminRepository.remover(codigo);
    }

    public List<AdminModels> buscar(){
        return this.adminRepository.buscar();
    }

    public AdminModels buscarPorCodigo(int codigo){
        return this.adminRepository.buscarPorCodigo(codigo);
    }
}
