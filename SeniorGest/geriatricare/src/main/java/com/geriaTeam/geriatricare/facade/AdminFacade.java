package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.AdminApplication;
import com.geriaTeam.geriatricare.models.domain.Admin;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AdminFacade {
    @Autowired
    private AdminApplication adminApplication;

    public List<Admin> buscar() {
        return adminApplication.buscar();
    }

    public Admin buscarPorCodigo(int codigo) {
        return adminApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Admin admin) {
        adminApplication.adicionar(admin);
    }

    public void atualizar(int codigo, Admin admin) {
        adminApplication.atualizar(codigo, admin);
    }

    public void remover(int codigo) {
        adminApplication.remover(codigo);
    }
}
