package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.Familiar;

import java.util.List;

public class FamiliarRepositoryImpl implements FamiliarRepository {
    @Override
    public Familiar buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Familiar> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Familiar familiar) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Familiar familiar) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
