package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;

import java.util.List;

public interface PacienteMedicamentoRepository {
    public PacienteMedicamento buscarPorCodigo(int codigo);
    public List<PacienteMedicamento> buscar();
    public void adicionar(PacienteMedicamento pacienteMedicamento);
    public void remover(int codigo);
    public void atualizar(PacienteMedicamento pacienteMedicamento);
}
