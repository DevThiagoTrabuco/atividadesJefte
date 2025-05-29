package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.AdminModels;
import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

public interface FuncionarioRepository {
    FuncionarioModels buscarPorCodigo(int codigo);
    List<FuncionarioModels> buscar();
    List<FuncionarioModels> buscarPorEmail(String email);
    void adicionar(FuncionarioModels funcionarioModels);
    void remover(int codigo);
    void atualizar(FuncionarioModels funcionarioModels);
}
