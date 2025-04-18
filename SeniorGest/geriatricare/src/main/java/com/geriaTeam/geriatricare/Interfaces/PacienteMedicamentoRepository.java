package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;

import java.util.List;

public interface PacienteMedicamentoRepository {
    public PacienteMedicamentoModels buscarPorCodigo(int codigo);
    public List<PacienteMedicamentoModels> buscar();
    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels);
    public void remover(int codigo);
    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels);
}
