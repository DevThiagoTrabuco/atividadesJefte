package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.domain.Historico;

@Repository
public class HistoricoRepositoryImpl implements HistoricoRepository {
    private List<Historico> historicos = new ArrayList<>();

    @Override
    public void adicionar(Historico historico) {
        historicos.add(historico);
    }

    @Override
    public void atualizar(int codigo, Historico historico) {
        Historico historicoEmMemoria = this.buscarPorCodigo(codigo);
        historicoEmMemoria.setId(historico.getId());
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
        .filter(l -> l.getId() == codigo)
        .findFirst()
        .get();

        return historico;
    }

    @Override
    public void remover(int codigo) {
        historicos.removeIf(l -> l.getId() == codigo);
    }

    
}
