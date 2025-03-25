package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.domain.Admin;

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
