package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.domain.Funcao;
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
    public Funcao buscarPorCodigo(int codigo){
        return this.funcaoJPA.findById(codigo).get();
    }

    @Override
    public List<Funcao> buscar(){
        return this.funcaoJPA.findAll();
    }

    @Override
    public void adicionar(Funcao funcao){
        this.funcaoJPA.save(funcao);
    }

    @Override
    public void remover(int codigo){
        this.funcaoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Funcao funcao){
        Funcao funcaoDB = this.funcaoJPA.findById(codigo).get();

        funcaoDB.setNome(funcao.getNome());
    }
}
