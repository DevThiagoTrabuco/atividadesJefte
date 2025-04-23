package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoApplication {
    private PlanoRepository planoRepository;


    @Autowired
    public PlanoApplication(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionar(PlanoModels planoModels){
        this.planoRepository.adicionar(planoModels);
    }

    public void atualizar(PlanoModels planoModels){
        this.planoRepository.atualizar(planoModels);
    }

    public void remover(int codigo){
        this.planoRepository.remover(codigo);
    }

    public List<PlanoModels> buscar(){
        return this.planoRepository.buscar();
    }

    public PlanoModels buscarPorCodigo(int codigo){
        return this.planoRepository.buscarPorCodigo(codigo);
    }
}

