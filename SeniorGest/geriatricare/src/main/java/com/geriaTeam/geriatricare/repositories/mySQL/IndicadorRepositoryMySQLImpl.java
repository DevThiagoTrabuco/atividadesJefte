package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.IndicadorModels;
import com.geriaTeam.geriatricare.repositories.jpa.IndicadorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndicadorRepositoryMySQLImpl implements IndicadorRepository {
    @Autowired
    private IndicadorJPA indicadorJPA;

    @Override
    public IndicadorModels buscarIndicadorId(int codigo) {
        return this.indicadorJPA.findById(codigo).get();
    }

    @Override
    public List<IndicadorModels> buscarIndicador() {
        return this.indicadorJPA.findAll();
    }

    @Override
    public void adicionarIndicador(IndicadorModels indicadorModels) {
        this.indicadorJPA.save(indicadorModels);
    }

    @Override
    public void removerIndicador(int codigo) {
        this.indicadorJPA.deleteById(codigo);
    }

    @Override
    public void atualizarIndicador(IndicadorModels indicadorModels) {
        this.indicadorJPA.save(indicadorModels);
    }
}
