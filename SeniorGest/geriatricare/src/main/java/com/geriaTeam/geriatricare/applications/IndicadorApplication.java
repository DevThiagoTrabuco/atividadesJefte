package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.IndicadorModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorApplication {
    private IndicadorRepository indicadorRepository;


    @Autowired
    public IndicadorApplication(IndicadorRepository indicadorRepository) {
        this.indicadorRepository = indicadorRepository;
    }

    public void adicionar(IndicadorModels indicadorModels){
        this.indicadorRepository.adicionar(indicadorModels);
    }

    public void atualizar(IndicadorModels indicadorModels){
        this.indicadorRepository.atualizar(indicadorModels);
    }

    public void remover(int codigo){
        this.indicadorRepository.remover(codigo);
    }

    public List<IndicadorModels> buscar(){
        return this.indicadorRepository.buscar();
    }

    public IndicadorModels buscarPorCodigo(int codigo){
        return this.indicadorRepository.buscarPorCodigo(codigo);
    }
}
