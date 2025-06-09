package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.HistoricoModels;
import com.geriaTeam.geriatricare.repositories.jpa.HistoricoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoricoRepositoryMySQLImpl implements HistoricoRepository {
    @Autowired
    private HistoricoJPA historicoJPA;

    @Override
    public HistoricoModels buscarHistoricoId(int codigo) {
        return this.historicoJPA.findById(codigo).get();
    }

    @Override
    public List<HistoricoModels> buscarHistorico() {
        return this.historicoJPA.findAll();
    }

    @Override
    public void adicionarHistorico(HistoricoModels historicoModels) {
        this.historicoJPA.save(historicoModels);
    }

    @Override
    public void removerHistorico(int codigo) {
        this.historicoJPA.deleteById(codigo);
    }

    @Override
    public void atualizarHistorico(HistoricoModels historicoModels) {
        this.historicoJPA.save(historicoModels);
    }
}
