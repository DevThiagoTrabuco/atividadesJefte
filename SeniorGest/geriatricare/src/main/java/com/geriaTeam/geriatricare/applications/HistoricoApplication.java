package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Historico;
import com.geriaTeam.geriatricare.repositories.HistoricoRepositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoApplication {
    private HistoricoRepositoryImpl historicoRepository;
    
    
    @Autowired
    public HistoricoApplication(HistoricoRepositoryImpl historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public void adicionar(Historico historico){
        this.historicoRepository.adicionar(historico);
    }

    public void atualizar(int codigo, Historico historico){
        this.historicoRepository.atualizar(codigo, historico);
    }

    public void remover(int codigo){
        this.historicoRepository.remover(codigo);
    }

    public List<Historico> buscar(){
        return this.historicoRepository.buscar();
    }

    public Historico buscarPorCodigo(int codigo){
        return this.historicoRepository.buscarPorCodigo(codigo);
    }
}
