package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

public interface FuncionarioRepository {
    public FuncionarioModels buscarFuncionarioId(int codigo);
    public List<FuncionarioModels> buscarFuncionario();
    public void adicionarFuncionario(FuncionarioModels funcionarioModels);
    public void removerFuncionario(int codigo);
    public void atualizarFuncionario(FuncionarioModels funcionarioModels);
}
