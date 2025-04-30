package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.PlanoModels;

public interface PlanoRepository {
    PlanoModels buscarPorCodigo(int codigo);
    List<PlanoModels> buscar();
    void adicionar(PlanoModels planoModels);
    void remover(int codigo);
    void atualizar(PlanoModels planoModels);
    List<PlanoModels> buscarPorNome(String nome);

}
