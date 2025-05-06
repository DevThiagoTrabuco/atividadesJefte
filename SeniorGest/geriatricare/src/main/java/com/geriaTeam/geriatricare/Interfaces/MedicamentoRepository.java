package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.MedicamentoModels;

import java.util.List;

public interface MedicamentoRepository {
    public MedicamentoModels buscarPorCodigo(int codigo);
    public List<MedicamentoModels> buscar();
    public void adicionar(MedicamentoModels medicamentoModels);
    public void remover(int codigo);
    public void atualizar(MedicamentoModels medicamentoModels);
}
