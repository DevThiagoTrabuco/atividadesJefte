package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.domain.Admin;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {
    @Override
    public Admin buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Admin> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Admin admin) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Admin admin) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
