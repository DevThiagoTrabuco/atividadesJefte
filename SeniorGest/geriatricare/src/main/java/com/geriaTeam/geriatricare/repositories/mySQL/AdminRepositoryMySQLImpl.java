package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.AdminModels;
import com.geriaTeam.geriatricare.repositories.jpa.AdminJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryMySQLImpl implements AdminRepository {
    private final AdminJPA adminJPA;

    @Autowired
    public AdminRepositoryMySQLImpl(AdminJPA adminJPA) {
        this.adminJPA = adminJPA;
    }

    @Override
    public AdminModels buscarPorCodigo(int codigo) {
        return this.adminJPA.findById(codigo).get();
    }

    @Override
    public List<AdminModels> buscar() {
        return this.adminJPA.findAll();
    }

    @Override
    public void adicionar(AdminModels adminModels) {
        this.adminJPA.save(adminModels);
    }

    @Override
    public void remover(int codigo) {
        this.adminJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(AdminModels adminModels) {
        this.adminJPA.save(adminModels);
    }
}
