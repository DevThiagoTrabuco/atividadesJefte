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
    public FuncaoModels buscarPorCodigo(int codigo){
        return this.funcaoJPA.findById(codigo).get();
    }

    @Override
    public List<FuncaoModels> buscar(){
        return this.funcaoJPA.findAll();
    }

    @Override
    public void adicionar(FuncaoModels funcaoModels){
        this.funcaoJPA.save(funcaoModels);
    }

    @Override
    public void remover(int codigo){
        this.funcaoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(FuncaoModels funcaoModels){
        this.funcaoJPA.save(funcaoModels);
    }
}
