package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
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
        this.adminRepository.adicionar(adminModels);
    }

    public void atualizar(AdminModels adminModels){
        this.adminRepository.atualizar(adminModels);
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
