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
    public PlanoModels buscarPlanoId(int codigo){
        return this.planoJPA.findById(codigo).get();
    }

    @Override
    public List<PlanoModels> buscarPlano(){
        return this.planoJPA.findAll();
    }

    @Override
    public void adicionarPlano(PlanoModels planoModels){
        this.planoJPA.save(planoModels);
    }

    @Override
    public void removerPlano(int codigo){
        this.planoJPA.deleteById(codigo);
    }

    @Override
    public void atualizarPlano(PlanoModels planoModels){
        this.planoJPA.save(planoModels);
    }

    @Override
    public List<PlanoModels> buscarPlanoNome(String nome) {
        return this.planoJPA.findByNome(nome);
    }
}
