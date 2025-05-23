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

    public List<AdminModels> buscar() {
        return adminApplication.buscar();
    }

    public AdminModels buscarPorCodigo(int codigo) {
        return adminApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(AdminModels adminModels) {
        adminApplication.adicionar(adminModels);
    }

    public void atualizarAdmin(int codigo, AdminModels adminModels) {
        adminApplication.atualizarAdmin(codigo ,adminModels);
    }

    public void remover(int codigo) {
        adminApplication.remover(codigo);
    }
}
