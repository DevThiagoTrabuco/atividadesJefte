package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.Familiar;

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

    public void adicionar(Familiar familiar){
        this.familiarRepository.adicionar(familiar);
    }

    public void atualizar(Familiar familiar){
        this.familiarRepository.atualizar(familiar);
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
