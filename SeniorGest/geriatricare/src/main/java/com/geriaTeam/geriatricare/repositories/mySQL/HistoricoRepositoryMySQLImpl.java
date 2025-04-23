package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.HistoricoRepository;
import com.geriaTeam.geriatricare.models.HistoricoModels;
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
    public HistoricoModels buscarPorCodigo(int codigo) {
        return this.historicoJPA.findById(codigo).get();
    }

    @Override
    public List<HistoricoModels> buscar() {
        return this.historicoJPA.findAll();
    }

    @Override
    public void adicionar(HistoricoModels historicoModels) {
        this.historicoJPA.save(historicoModels);
    }

    @Override
    public void remover(int codigo) {
        this.historicoJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(HistoricoModels historicoModels) {
        this.historicoJPA.save(historicoModels);
    }
}
