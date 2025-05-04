package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.AdminModels;
import com.geriaTeam.geriatricare.repositories.jpa.AdminJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepositoryMySQLImpl implements AdminRepository {
    @Autowired
    private AdminJPA adminJPA;

    @Override
    public AdminModels buscarAdminId(int codigo) {
        return this.adminJPA.findById(codigo).orElse(null);
    }

    @Override
    public List<AdminModels> buscarAdmin() {
        return this.adminJPA.findAll();
    }

    @Override
    public void adicionarAdmin(AdminModels adminModels) {
        this.adminJPA.save(adminModels);
    }

    @Override
    public void removerAdmin(int codigo) {
        this.adminJPA.deleteById(codigo);
    }

    @Override
    public void atualizarAdmin(AdminModels adminModels) {
        this.adminJPA.save(adminModels);
    }

}
