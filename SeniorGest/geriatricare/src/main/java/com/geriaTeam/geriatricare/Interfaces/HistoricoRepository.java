package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.HistoricoModels;

public interface HistoricoRepository {
    HistoricoModels buscarPorCodigo(int codigo);
    List<HistoricoModels> buscar();
    void adicionar(HistoricoModels historicoModels);
    void remover(int codigo);
    void atualizar(HistoricoModels historicoModels);
}
