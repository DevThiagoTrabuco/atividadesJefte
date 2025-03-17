package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.domain.Admin;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    private List<Admin> admins = new ArrayList<>();

    @Override
    public void adicionar(Admin admin) {
        admins.add(admin);
    }

    @Override
    public void atualizar(int codigo, Admin admin) {
        Admin adminEmMemoria = this.buscarPorCodigo(codigo);
        adminEmMemoria.setNome(admin.getNome());
        adminEmMemoria.setId(admin.getId());
        adminEmMemoria.setSenha(admin.getSenha());       
    }

    @Override
    public List<Admin> buscar() {
        return admins;
    }

    @Override
    public Admin buscarPorCodigo(int codigo) {
        Admin admin = admins
        .stream()
        .filter(l -> l.getId() == codigo)
        .findFirst()
        .get();

        return admin;
    }

    @Override
    public void remover(int codigo) {
        admins.removeIf(l -> l.getId() == codigo);
    }

    
}
