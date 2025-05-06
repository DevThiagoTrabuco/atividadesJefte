package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.IndicadorModels;

public interface IndicadorRepository {
    public IndicadorModels buscarIndicadorId(int codigo);
    public List<IndicadorModels> buscarIndicador();
    public void adicionarIndicador(IndicadorModels indicadorModels);
    public void removerIndicador(int codigo);
    public void atualizarIndicador(IndicadorModels indicadorModels);
}
