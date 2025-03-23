package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.SinaisVitais;
import com.geriaTeam.geriatricare.repositories.SinaisVitaisRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinaisVitaisApplication {
    private SinaisVitaisRepository sinaisvitaisRepository;


    @Autowired
    public SinaisVitaisApplication(SinaisVitaisRepository sinaisvitaisRepository) {
        this.sinaisvitaisRepository = sinaisvitaisRepository;
    }

    public void adicionar(SinaisVitais sinaisvitais){
        this.sinaisvitaisRepository.adicionar(sinaisvitais);
    }

    public void atualizar(int codigo, SinaisVitais sinaisvitais){
        this.sinaisvitaisRepository.atualizar(codigo, sinaisvitais);
    }

    public void remover(int codigo){
        this.sinaisvitaisRepository.remover(codigo);
    }

    public List<SinaisVitais> buscar(){
        return this.sinaisvitaisRepository.buscar();
    }

    public SinaisVitais buscarPorCodigo(int codigo){
        return this.sinaisvitaisRepository.buscarPorCodigo(codigo);
    }
}
