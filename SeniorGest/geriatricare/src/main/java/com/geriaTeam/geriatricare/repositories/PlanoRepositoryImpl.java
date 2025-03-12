package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.domain.Plano;

import java.util.List;

public class PlanoRepositoryImpl implements PlanoRepository {
    @Override
    public Plano buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Plano> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Plano plano) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Plano plano) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
