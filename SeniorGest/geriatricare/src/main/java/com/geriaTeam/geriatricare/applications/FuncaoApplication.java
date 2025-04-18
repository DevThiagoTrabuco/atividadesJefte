package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncaoApplication {
    private FuncaoRepository funcaoRepository;
    
    
    @Autowired
    public FuncaoApplication(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public void adicionar(FuncaoModels funcaoModels){
        this.funcaoRepository.adicionar(funcaoModels);
    }

    public void atualizar(FuncaoModels funcaoModels){
        this.funcaoRepository.atualizar(funcaoModels);
    }

    public void remover(int code){
        this.funcaoRepository.remover(code);
    }

    public List<FuncaoModels> buscar(){
        return this.funcaoRepository.buscar();
    }

    public FuncaoModels buscarPorCodigo(int code){
        return this.funcaoRepository.buscarPorCodigo(code);
    }
}
