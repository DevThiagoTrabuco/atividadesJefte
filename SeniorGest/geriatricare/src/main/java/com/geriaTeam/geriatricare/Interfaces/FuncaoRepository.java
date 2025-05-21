package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.FuncaoModels;

import java.util.List;

public interface FuncaoRepository {
    public FuncaoModels buscarFuncaoId(int codigo);
    public List<FuncaoModels> buscarFuncao();
    public void adicionarFuncao(FuncaoModels funcaoModels);
    public void removerFuncao(int codigo);
    public void atualizarFuncao(FuncaoModels funcaoModels);
}
