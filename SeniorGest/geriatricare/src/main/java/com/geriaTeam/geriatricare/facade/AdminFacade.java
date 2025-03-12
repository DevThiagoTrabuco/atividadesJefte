package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Admin buscarPorCodigo(UUID codigo) {
        return adminApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Admin admin) {
        adminApplication.cadastrar(admin);
    }

    public void atualizar(UUID codigo, Admin admin) {
        adminApplication.atualizar(codigo, admin);
    }

    public void remover(UUID codigo, Admin admin) {
        adminApplication.remover(codigo, admin);
    }
}
