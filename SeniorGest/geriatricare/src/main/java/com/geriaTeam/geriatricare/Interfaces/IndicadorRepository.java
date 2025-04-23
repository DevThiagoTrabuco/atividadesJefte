package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.IndicadorModels;

public interface IndicadorRepository {
    public IndicadorModels buscarPorCodigo(int codigo);
    public List<IndicadorModels> buscar();
    public void adicionar(IndicadorModels indicadorModels);
    public void remover(int codigo);
    public void atualizar(IndicadorModels indicadorModels);
}
