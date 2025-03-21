package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Familiar;
import com.geriaTeam.geriatricare.repositories.FamiliarRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliarApplication {
    private FamiliarRepositoryImpl familiarRepository;
    
    
    @Autowired
    public FamiliarApplication(FamiliarRepositoryImpl familiarRepository) {
        this.familiarRepository = familiarRepository;
    }

    public void adicionar(Familiar familiar){
        this.familiarRepository.adicionar(familiar);
    }

    public void atualizar(int codigo, Familiar familiar){
        this.familiarRepository.atualizar(codigo, familiar);
    }

    public void remover(int codigo){
        this.familiarRepository.remover(codigo);
    }

    public List<Familiar> buscar(){
        return this.familiarRepository.buscar();
    }

    public Familiar buscarPorCodigo(int codigo){
        return this.familiarRepository.buscarPorCodigo(codigo);
    }
}
