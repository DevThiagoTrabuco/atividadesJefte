package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.models.FuncionarioModels;
import com.geriaTeam.geriatricare.repositories.jpa.FuncionarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioRepositoryMySQLImpl implements FuncionarioRepository {
    @Autowired
    private FuncionarioJPA funcionarioJPA;

    @Override
    public FuncionarioModels buscarFuncionarioId(int codigo) {
        return this.funcionarioJPA.findById(codigo).get();
    }

    @Override
    public List<FuncionarioModels> buscarFuncionario() {
        return this.funcionarioJPA.findAll();
    }

    @Override
    public void adicionarFuncionario(FuncionarioModels funcionarioModels) {
        this.funcionarioJPA.save(funcionarioModels);
    }

    @Override
    public void removerFuncionario(int codigo) {
        this.funcionarioJPA.deleteById(codigo);
    }

    @Override
    public void atualizarFuncionario(FuncionarioModels funcionarioModels) {
        this.funcionarioJPA.save(funcionarioModels);
    }
}
