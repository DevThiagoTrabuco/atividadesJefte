package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.AdminApplication;
import com.geriaTeam.geriatricare.models.AdminModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AdminFacade {
    @Autowired
    private AdminApplication adminApplication;

    public List<AdminModels> buscarAdmin() {return adminApplication.buscarAdmin();}

    public AdminModels buscarAdminId(int codigo) {
        return adminApplication.buscarAdminId(codigo);
    }

    public void adicionarAdmin(AdminModels adminModels) {
        adminApplication.adicionarAdmin(adminModels);
    }

    public void atualizarAdmin(AdminModels adminModels) {
        adminApplication.atualizarAdmin(adminModels);
    }

    public void removerAdmin(int codigo) {
        adminApplication.removerAdmin(codigo);
    }

    public AdminModels autenticarAdmin(String login, String senha) {
        return adminApplication.autenticarAdmin(login, senha);
    }
}
