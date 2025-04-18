package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.FuncaoModels;

import java.util.List;

public interface FuncaoRepository {
    public FuncaoModels buscarPorCodigo(int codigo);
    public List<FuncaoModels> buscar();
    public void adicionar(FuncaoModels funcaoModels);
    public void remover(int codigo);
    public void atualizar(FuncaoModels funcaoModels);
}
