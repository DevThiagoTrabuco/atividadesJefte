package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.MedicamentoModels;

import java.util.List;

public interface MedicamentoRepository {
    public MedicamentoModels buscarMedicamentoId(int codigo);
    public List<MedicamentoModels> buscarMedicamento();
    public void adicionarMedicamento(MedicamentoModels medicamentoModels);
    public void removerMedicamento(int codigo);
    public void atualizarMedicamento(MedicamentoModels medicamentoModels);
}
