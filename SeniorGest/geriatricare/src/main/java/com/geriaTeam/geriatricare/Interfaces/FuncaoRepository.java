package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.FuncaoModels;

import java.util.List;

public interface FuncaoRepository {
    FuncaoModels buscarFuncaoId(int codigo);
    List<FuncaoModels> buscarFuncao();
    void adicionarFuncao(FuncaoModels funcaoModels);
    void removerFuncao(int codigo);
    void atualizarFuncao(FuncaoModels funcaoModels);
}
