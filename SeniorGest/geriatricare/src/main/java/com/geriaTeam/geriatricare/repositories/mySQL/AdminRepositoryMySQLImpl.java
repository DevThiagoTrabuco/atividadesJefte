package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.AdminRepository;
import com.geriaTeam.geriatricare.models.domain.Admin;
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
    public Admin buscarPorCodigo(int codigo) {
        return this.adminJPA.findById(codigo).get();
    }

    @Override
    public List<Admin> buscar() {
        return this.adminJPA.findAll();
    }

    @Override
    public void adicionar(Admin admin) {
        this.adminJPA.save(admin);
    }

    @Override
    public void remover(int codigo) {
        this.adminJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Admin admin) {
        Admin adminDB = this.adminJPA.findById(codigo).get();
        
        adminDB.setNome(admin.getNome());
        adminDB.setSenha(admin.getSenha());

        this.adminJPA.save(adminDB);
    }
}
