package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.AdminModels;

public interface AdminRepository {
    AdminModels buscarPorCodigo(int codigo);
    List<AdminModels> buscar();
    List<AdminModels> buscarPorEmail(String email);
    void adicionar(AdminModels adminModels);
    void remover(int codigo);
    void atualizar(AdminModels adminModels);
}
