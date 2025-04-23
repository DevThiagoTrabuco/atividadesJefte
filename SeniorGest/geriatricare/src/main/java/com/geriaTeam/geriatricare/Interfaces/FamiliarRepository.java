package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.FamiliarModels;

public interface FamiliarRepository {
    public FamiliarModels buscarPorCodigo(int codigo);
    public List<FamiliarModels> buscar();
    public void adicionar(FamiliarModels familiarModels);
    public void remover(int codigo);
    public void atualizar(FamiliarModels familiarModels);
}
