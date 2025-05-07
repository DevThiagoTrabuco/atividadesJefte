package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.repositories.jpa.FuncaoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncaoMySQLImpl implements FuncaoRepository {
    private final FuncaoJPA funcaoJPA;

    @Autowired
    public FuncaoMySQLImpl (FuncaoJPA funcaoJPA){
        this.funcaoJPA = funcaoJPA;
    }

    @Override
    public FuncaoModels buscarFuncaoId(int codigo){
        return this.funcaoJPA.findById(codigo).get();
    }

    @Override
    public List<FuncaoModels> buscarFuncao(){
        return this.funcaoJPA.findAll();
    }

    @Override
    public void adicionarFuncao(FuncaoModels funcaoModels){
        this.funcaoJPA.save(funcaoModels);
    }

    @Override
    public void removerFuncao(int codigo){
        this.funcaoJPA.deleteById(codigo);
    }

    @Override
    public void atualizarFuncao(FuncaoModels funcaoModels){
        this.funcaoJPA.save(funcaoModels);
    }
}
