package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.domain.Historico;
import com.geriaTeam.geriatricare.repositories.jpa.HistoricoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoricoRepositoryMySQLImpl implements HistoricoRepository {
    private final HistoricoJPA historicoJPA;

    @Autowired
    public HistoricoRepositoryMySQLImpl(HistoricoJPA historicoJPA) {
        this.historicoJPA = historicoJPA;
    }

    @Override
    public Historico buscarPorCodigo(int codigo) {
        return this.historicoJPA.findById(codigo).get();
    }

    @Override
    public List<Historico> buscar() {
        return this.historicoJPA.findAll();
    }

    @Override
    public void adicionar(Historico historico) {
        this.historicoJPA.save(historico);
    }

    @Override
    public void remover(int codigo) {
        this.historicoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Historico historico) {
        Historico historicoDB = this.historicoJPA.findById(codigo).get();

        historicoDB.setDataAlteracao(historico.getDataAlteracao());

        this.historicoJPA.save(historicoDB);
    }
}
