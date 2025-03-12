package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Plano;

import java.util.List;

public interface PlanoRepository {
    public Plano buscarPorCodigo(int codigo);
    public List<Plano> buscar();
    public void adicionar(Plano plano);
    public void remover(int codigo);
    public void atualizar(int codigo, Plano plano);
    public boolean vazio();
}