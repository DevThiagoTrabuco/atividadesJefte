package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.domain.Indicador;

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

    public void adicionar(Indicador indicador){
        this.indicadorRepository.adicionar(indicador);
    }

    public void atualizar(int codigo, Indicador indicador){
        this.indicadorRepository.atualizar(codigo, indicador);
    }

    public void remover(int codigo){
        this.indicadorRepository.remover(codigo);
    }

    public List<Indicador> buscar(){
        return this.indicadorRepository.buscar();
    }

    public Indicador buscarPorCodigo(int codigo){
        return this.indicadorRepository.buscarPorCodigo(codigo);
    }
}
