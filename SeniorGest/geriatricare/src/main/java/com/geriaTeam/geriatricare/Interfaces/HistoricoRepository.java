package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.HistoricoModels;

public interface HistoricoRepository {
    public HistoricoModels buscarHistoricoId(int codigo);
    public List<HistoricoModels> buscarHistorico();
    public void adicionarHistorico(HistoricoModels historicoModels);
    public void removerHistorico(int codigo);
    public void atualizarHistorico(HistoricoModels historicoModels);
}
