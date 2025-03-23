package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.SinaisVitaisRepository;
import com.geriaTeam.geriatricare.models.domain.SinaisVitais;


public class SinaisVitaisRepositoryImpl implements SinaisVitaisRepository {
    private List<SinaisVitais> sinaisVitaiss = new ArrayList<>();

    @Override
    public void adicionar(SinaisVitais sinaisVitais) {
        sinaisVitaiss.add(sinaisVitais);
    }

    @Override
    public void atualizar(int codigo, SinaisVitais sinaisVitais) {
        SinaisVitais sinaisVitaisEmMemoria = this.buscarPorCodigo(codigo);
        sinaisVitaisEmMemoria.setSinaisVitaisId(sinaisVitais.getSinaisVitaisId());
        sinaisVitaisEmMemoria.setDataAlteracao(sinaisVitais.getDataAlteracao());
    }

    @Override
    public List<Historico> buscar() {
        return historicos;
    }

    @Override
    public Historico buscarPorCodigo(int codigo) {
        Historico historico = historicos
        .stream()
        .filter(l -> l.getHistoricoId() == codigo)
        .findFirst()
        .get();

        return historico;
    }

    @Override
    public void remover(int codigo) {
        historicos.removeIf(l -> l.getHistoricoId() == codigo);
    }

    
}