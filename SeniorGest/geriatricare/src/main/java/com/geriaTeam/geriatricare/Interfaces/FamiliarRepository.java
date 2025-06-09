package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.FamiliarModels;

public interface FamiliarRepository {
    FamiliarModels buscarPorCodigo(int codigo);
    FamiliarModels buscarPorCpf(String cpf);
    List<FamiliarModels> buscarPorNome(String nome);
    List<FamiliarModels> buscar();
    void adicionar(FamiliarModels familiarModels);
    void remover(int codigo);
    void atualizar(FamiliarModels familiarModels);
}
