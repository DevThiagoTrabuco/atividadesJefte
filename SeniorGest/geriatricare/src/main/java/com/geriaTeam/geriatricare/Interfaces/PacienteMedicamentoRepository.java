package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;

import java.util.List;

public interface PacienteMedicamentoRepository {
    public PacienteMedicamentoModels buscarPacienteMedicamentoId(int codigo);
    public List<PacienteMedicamentoModels> buscarPacienteMedicamento();
    public void adicionarPacienteMedicamento(PacienteMedicamentoModels pacienteMedicamentoModels);
    public void removerPacienteMedicamento(int codigo);
    public void atualizarPacienteMedicamento(PacienteMedicamentoModels pacienteMedicamentoModels);

}
