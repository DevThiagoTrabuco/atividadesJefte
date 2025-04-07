package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Funcao;
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

    public void adicionar(Funcao funcao){
        this.funcaoRepository.adicionar(funcao);
    }

    public void atualizar(Funcao funcao){
        this.funcaoRepository.atualizar(funcao);
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
