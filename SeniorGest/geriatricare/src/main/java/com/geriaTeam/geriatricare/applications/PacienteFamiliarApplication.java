package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteFamiliarApplication {
    private PacienteFamiliarRepository pacienteFamiliarRepository;

    public void adicionar(PacienteFamiliarModels pacienteFamiliarModels){
        this.pacienteFamiliarRepository.adicionar(pacienteFamiliarModels);
    }

    public void atualizar(PacienteFamiliarModels pacienteFamiliarModels){
        this.pacienteFamiliarRepository.atualizar(pacienteFamiliarModels);
    }

    public void remover(int codigo){
        this.pacienteFamiliarRepository.remover(codigo);
    }

    public List<PacienteFamiliarModels> buscar(){
        return this.pacienteFamiliarRepository.buscar();
    }

    public PacienteFamiliarModels buscarPorCodigo(int codigo){
        return this.pacienteFamiliarRepository.buscarPorCodigo(codigo);
    }
}
