package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.domain.Historico;


public class HistoricoRepositoryImpl implements HistoricoRepository {
    private List<Historico> historicos = new ArrayList<>();

    @Override
    public void adicionar(Historico historico) {
        historicos.add(historico);
    }

    @Override
    public void atualizar(int codigo, Historico historico) {
        Historico historicoEmMemoria = this.buscarPorCodigo(codigo);
        historicoEmMemoria.setHistoricoId(historico.getHistoricoId());
        historicoEmMemoria.setDataAlteracao(historico.getDataAlteracao());
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
