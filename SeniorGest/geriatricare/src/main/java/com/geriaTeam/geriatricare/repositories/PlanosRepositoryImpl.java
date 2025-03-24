package com.geriaTeam.geriatricare.repositories;


import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.domain.Plano;

import java.util.ArrayList;
import java.util.List;


public class PlanosRepositoryImpl implements PlanoRepository {
    private List<Plano> planoss = new ArrayList<>();

    @Override
    public void adicionar(Plano plano) {
        planoss.add(plano);
    }

    @Override
    public void atualizar(int codigo, Plano plano) {
        Plano planoEmMemoria = this.buscarPorCodigo(codigo);
        planoEmMemoria.setNome(plano.getNome());
        planoEmMemoria.setId(plano.getId());
    }

    @Override
    public List<Plano> buscar() {
        return planoss;
    }

    @Override
    public Plano buscarPorCodigo(int codigo) {
        Plano plano = planoss
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return plano;
    }

    @Override
    public void remover(int codigo) {planoss.removeIf(l -> l.getId() == codigo);}
}


