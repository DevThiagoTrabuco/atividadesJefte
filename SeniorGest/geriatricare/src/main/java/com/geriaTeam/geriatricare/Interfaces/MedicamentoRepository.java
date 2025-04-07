package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.domain.Medicamento;

import java.util.List;

public interface MedicamentoRepository {
    public Medicamento buscarPorCodigo(int codigo);
    public List<Medicamento> buscar();
    public void adicionar(Medicamento medicamento);
    public void remover(int codigo);
    public void atualizar(Medicamento medicamento);
}
