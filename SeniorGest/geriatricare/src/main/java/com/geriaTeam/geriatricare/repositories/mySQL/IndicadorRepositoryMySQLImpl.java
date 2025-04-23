package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.IndicadorModels;
import com.geriaTeam.geriatricare.repositories.jpa.IndicadorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndicadorRepositoryMySQLImpl implements IndicadorRepository {
    private final IndicadorJPA indicadorJPA;

    @Autowired
    public IndicadorRepositoryMySQLImpl(IndicadorJPA indicadorJPA) {
        this.indicadorJPA = indicadorJPA;
    }

    @Override
    public IndicadorModels buscarPorCodigo(int codigo) {
        return this.indicadorJPA.findById(codigo).get();
    }

    @Override
    public List<IndicadorModels> buscar() {
        return this.indicadorJPA.findAll();
    }

    @Override
    public void adicionar(IndicadorModels indicadorModels) {
        this.indicadorJPA.save(indicadorModels);
    }

    @Override
    public void remover(int codigo) {
        this.indicadorJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(IndicadorModels indicadorModels) {
        this.indicadorJPA.save(indicadorModels);
    }
}
