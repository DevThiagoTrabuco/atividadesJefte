package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliarApplication {
    private FamiliarRepository familiarRepository;
    
    
    @Autowired
    public FamiliarApplication(FamiliarRepository familiarRepository) {
        this.familiarRepository = familiarRepository;
    }

    public void adicionar(FamiliarModels familiarModels){
        this.familiarRepository.adicionar(familiarModels);
    }

    public void atualizar(FamiliarModels familiarModels){
        this.familiarRepository.atualizar(familiarModels);
    }

    public void remover(int codigo){
        this.familiarRepository.remover(codigo);
    }

    public List<FamiliarModels> buscar(){
        return this.familiarRepository.buscar();
    }

    public FamiliarModels buscarPorCodigo(int codigo){
        return this.familiarRepository.buscarPorCodigo(codigo);
    }
}
