package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.AdminModels;

public interface AdminRepository {
    public AdminModels buscarPorCodigo(int codigo);
    public List<AdminModels> buscar();
    public void adicionar(AdminModels adminModels);
    public void remover(int codigo);
    public void atualizar(AdminModels adminModels);
}
