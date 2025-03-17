package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.domain.Medicamentos;

import java.util.List;

public interface MedicamentosRepository {
    public Medicamentos buscarPorCodigo(int codigo);
    public List<Medicamentos> buscar();
    public void adicionar(Medicamentos medicamentos);
    public void remover(int codigo);
    public void atualizar(int codigo, Medicamentos medicamentos);
}
