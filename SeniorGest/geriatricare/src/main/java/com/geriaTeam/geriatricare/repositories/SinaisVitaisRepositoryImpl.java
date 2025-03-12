package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.SinaisVitaisRepository;
import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

import java.util.List;

public class SinaisVitaisRepositoryImpl implements SinaisVitaisRepository {
    @Override
    public SinaisVitais buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<SinaisVitais> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(SinaisVitais sinaisVitais) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, SinaisVitais sinaisVitais) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
