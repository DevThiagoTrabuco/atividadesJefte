package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.domain.Plano;
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

    public void adicionar(Plano plano){
        this.planoRepository.adicionar(plano);
    }

    public void atualizar(Plano plano){
        this.planoRepository.atualizar(plano);
    }

    public void remover(int codigo){
        this.planoRepository.remover(codigo);
    }

    public List<Plano> buscar(){
        return this.planoRepository.buscar();
    }

    public Plano buscarPorCodigo(int codigo){
        return this.planoRepository.buscarPorCodigo(codigo);
    }
}

