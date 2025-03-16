package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Plano;
import com.geriaTeam.geriatricare.repositories.PlanosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoApplication {
    private PlanosRepositoryImpl planoRepository;


    @Autowired
    public PlanoApplication(PlanosRepositoryImpl planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionar(Plano plano){
        this.planoRepository.adicionar(plano);
    }

    public void atualizar(int codigo, Plano plano){
        this.planoRepository.atualizar(codigo, plano);
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

