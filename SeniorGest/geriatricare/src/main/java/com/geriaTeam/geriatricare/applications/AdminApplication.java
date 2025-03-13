package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Admin;
import com.geriaTeam.geriatricare.repositories.AdminRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminApplication {
    private AdminRepositoryImpl adminRepository;
    
    
    @Autowired
    public AdminApplication(AdminRepositoryImpl adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void adicionar(Admin admin){
        this.adminRepository.adicionar(admin);
    }

    public void atualizar(int codigo, Admin admin){
        this.adminRepository.atualizar(codigo, admin);
    }

    public void remover(int codigo){
        this.adminRepository.remover(codigo);
    }

    public List<Admin> buscar(){
        return this.adminRepository.buscar();
    }

    public Admin buscarPorCodigo(int codigo){
        return this.adminRepository.buscarPorCodigo(codigo);
    }
}
