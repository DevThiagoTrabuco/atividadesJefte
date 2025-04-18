package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import com.geriaTeam.geriatricare.repositories.jpa.CondicaoFisicaJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CondicaoFisicaRepositoryMySQLImpl implements CondicaoFisicaRepository {
    private final CondicaoFisicaJPA condicaoFisicaJPA;

    @Autowired
    public CondicaoFisicaRepositoryMySQLImpl(CondicaoFisicaJPA condicaoFisicaJPA) {
        this.condicaoFisicaJPA = condicaoFisicaJPA;
    }

    @Override
    public CondicaoFisicaModels buscarPorCodigo(int codigo) {
        return condicaoFisicaJPA.findById(codigo).get();
    }

    @Override
    public List<CondicaoFisicaModels> buscar() {
        return condicaoFisicaJPA.findAll();
    }

    @Override
    public void adicionar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaJPA.save(condicaoFisicaModels);
    }

    @Override
    public void remover(int codigo) {
        condicaoFisicaJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaJPA.save(condicaoFisicaModels);
    }
}
