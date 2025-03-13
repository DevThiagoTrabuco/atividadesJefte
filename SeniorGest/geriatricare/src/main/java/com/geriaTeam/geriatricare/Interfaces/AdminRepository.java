package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.Admin;

public interface AdminRepository {
    public Admin buscarPorCodigo(int codigo);
    public List<Admin> buscar();
    public void adicionar(Admin admin);
    public void remover(int codigo);
    public void atualizar(int codigo, Admin admin);
}
