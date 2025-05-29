package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;

import java.util.List;

public interface PacienteMedicamentoRepository {
    PacienteMedicamentoModels buscarPacienteMedicamentoId(int codigo);
    List<PacienteMedicamentoModels> buscarPacienteMedicamento();
    void adicionarPacienteMedicamento(PacienteMedicamentoModels pacienteMedicamentoModels);
    void removerPacienteMedicamento(int codigo);
    void atualizarPacienteMedicamento(PacienteMedicamentoModels pacienteMedicamentoModels);

}
