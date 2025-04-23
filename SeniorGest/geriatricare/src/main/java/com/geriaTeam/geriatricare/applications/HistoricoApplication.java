package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.HistoricoModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoApplication {
    private HistoricoRepository historicoRepository;


    @Autowired
    public HistoricoApplication(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void adicionar(HistoricoModels historicoModels){
        this.historicoRepository.adicionar(historicoModels);
    }

    public void atualizar(HistoricoModels historicoModels){
        this.historicoRepository.atualizar(historicoModels);
    }

    public void remover(int codigo){
        this.historicoRepository.remover(codigo);
    }

    public List<HistoricoModels> buscar(){
        return this.historicoRepository.buscar();
    }

    public HistoricoModels buscarPorCodigo(int codigo){
        return this.historicoRepository.buscarPorCodigo(codigo);
    }
}
