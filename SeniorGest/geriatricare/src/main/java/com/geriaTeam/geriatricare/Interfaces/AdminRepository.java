package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.AdminModels;

public interface AdminRepository {
    public AdminModels buscarAdminId(int codigo);
    public List<AdminModels> buscarAdmin();
    public void adicionarAdmin(AdminModels adminModels);
    public void removerAdmin(int codigo);
    public void atualizarAdmin(AdminModels adminModels);
}
