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
    public CondicaoFisicaModels buscarCondicaoFisicaId(int codigo) {
        return condicaoFisicaJPA.findById(codigo).get();
    }

    @Override
    public List <CondicaoFisicaModels> buscarCondicaoFisicaPorNome(String nome) {
        return condicaoFisicaJPA.findByNome(nome);
    }

    @Override
    public List<CondicaoFisicaModels> buscarCondicaoFisica() {
        return condicaoFisicaJPA.findAll();
    }

    @Override
    public void adicionarCondicaoFisica(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaJPA.save(condicaoFisicaModels);
    }

    @Override
    public void removerCondicaoFisica(int codigo) {
        condicaoFisicaJPA.deleteById(codigo);
    }

    @Override
    public void atualizarCondicaoFisica(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaJPA.save(condicaoFisicaModels);
    }
}
