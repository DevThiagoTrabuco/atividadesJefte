package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.Plano;

public interface PlanoRepository {
    public Plano buscarPorCodigo(int codigo);
    public List<Plano> buscar();
    public void adicionar(Plano plano);
    public void remover(int codigo);
    public void atualizar(Plano plano);
}
