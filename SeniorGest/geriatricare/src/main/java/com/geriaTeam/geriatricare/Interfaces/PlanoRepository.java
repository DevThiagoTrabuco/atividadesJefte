package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.PlanoModels;

public interface PlanoRepository {
    public PlanoModels buscarPorCodigo(int codigo);
    public List<PlanoModels> buscar();
    public void adicionar(PlanoModels planoModels);
    public void remover(int codigo);
    public void atualizar(PlanoModels planoModels);
}
