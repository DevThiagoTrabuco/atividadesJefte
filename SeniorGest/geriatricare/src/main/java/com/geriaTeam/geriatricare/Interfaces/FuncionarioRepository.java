package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

public interface FuncionarioRepository {
    public FuncionarioModels buscarPorCodigo(int codigo);
    public List<FuncionarioModels> buscar();
    public void adicionar(FuncionarioModels funcionarioModels);
    public void remover(int codigo);
    public void atualizar(FuncionarioModels funcionarioModels);
}
