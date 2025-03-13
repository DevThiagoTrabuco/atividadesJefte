package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Funcao;
import com.geriaTeam.geriatricare.repositories.FuncaoRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncaoApplication {
    private FuncaoRepositoryImpl funcaoRepository;
    
    
    @Autowired
    public FuncaoApplication(FuncaoRepositoryImpl funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public void adicionar(Funcao funcao){
        this.funcaoRepository.adicionar(funcao);
    }

    public void atualizar(int code, Funcao funcao){
        this.funcaoRepository.atualizar(code, funcao);
    }

    public void remover(int code){
        this.funcaoRepository.remover(code);
    }

    public List<Funcao> buscar(){
        return this.funcaoRepository.buscar();
    }

    public Funcao buscarPorCodigo(int code){
        return this.funcaoRepository.buscarPorCodigo(code);
    }
}
