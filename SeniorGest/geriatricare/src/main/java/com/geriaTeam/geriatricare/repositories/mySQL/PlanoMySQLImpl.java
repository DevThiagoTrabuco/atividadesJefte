package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.PlanoModels;
import com.geriaTeam.geriatricare.repositories.jpa.PlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanoMySQLImpl implements PlanoRepository {
    private final PlanoJPA planoJPA;

    @Autowired
    public PlanoMySQLImpl(PlanoJPA planoJPA){
        this.planoJPA = planoJPA;
    }

    @Override
    public PlanoModels buscarPorCodigo(int codigo){
        return this.planoJPA.findById(codigo).get();
    }

    @Override
    public List<PlanoModels> buscar(){
        return this.planoJPA.findAll();
    }

    @Override
    public void adicionar(PlanoModels planoModels){
        this.planoJPA.save(planoModels);
    }

    @Override
    public void remover(int codigo){
        this.planoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(PlanoModels planoModels){
        this.planoJPA.save(planoModels);
    }
}
