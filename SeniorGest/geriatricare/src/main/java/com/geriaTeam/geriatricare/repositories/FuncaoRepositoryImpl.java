package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.domain.Funcao;

import java.util.List;

public class FuncaoRepositoryImpl implements FuncaoRepository {
    @Override
    public Funcao buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Funcao> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Funcao funcao) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Funcao funcao) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
