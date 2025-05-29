package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.MedicamentoModels;

import java.util.List;

public interface MedicamentoRepository {
    MedicamentoModels buscarPorCodigo(int codigo);
    List<MedicamentoModels> buscar();
    void adicionar(MedicamentoModels medicamentoModels);
    void remover(int codigo);
    void atualizar(MedicamentoModels medicamentoModels);
}
