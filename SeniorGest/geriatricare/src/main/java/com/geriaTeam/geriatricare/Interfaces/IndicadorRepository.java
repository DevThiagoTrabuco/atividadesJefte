package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.IndicadorModels;

public interface IndicadorRepository {
    IndicadorModels buscarPorCodigo(int codigo);
    List<IndicadorModels> buscar();
    void adicionar(IndicadorModels indicadorModels);
    void remover(int codigo);
    void atualizar(IndicadorModels indicadorModels);
}
