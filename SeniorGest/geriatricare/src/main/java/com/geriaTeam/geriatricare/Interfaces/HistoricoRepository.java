package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.HistoricoModels;

public interface HistoricoRepository {
    public HistoricoModels buscarPorCodigo(int codigo);
    public List<HistoricoModels> buscar();
    public void adicionar(HistoricoModels historicoModels);
    public void remover(int codigo);
    public void atualizar(HistoricoModels historicoModels);
}
