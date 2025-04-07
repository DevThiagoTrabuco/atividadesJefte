package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.PacienteFamiliar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteFamiliarApplication {
    private PacienteFamiliarRepository pacienteFamiliarRepository;

    public void adicionar(PacienteFamiliar pacienteFamiliar){
        this.pacienteFamiliarRepository.adicionar(pacienteFamiliar);
    }

    public void atualizar(PacienteFamiliar pacienteFamiliar){
        this.pacienteFamiliarRepository.atualizar(pacienteFamiliar);
    }

    public void remover(int codigo){
        this.pacienteFamiliarRepository.remover(codigo);
    }

    public List<PacienteFamiliar> buscar(){
        return this.pacienteFamiliarRepository.buscar();
    }

    public PacienteFamiliar buscarPorCodigo(int codigo){
        return this.pacienteFamiliarRepository.buscarPorCodigo(codigo);
    }
}
