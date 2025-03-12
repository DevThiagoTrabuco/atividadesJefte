package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Admin;

import java.util.List;

public interface AdminRepository {
    public Admin buscarPorCodigo(int codigo);
    public List<Admin> buscar();
    public void adicionar(Admin admin);
    public void remover(int codigo);
    public void atualizar(int codigo, Admin admin);
    public boolean vazio();
}

