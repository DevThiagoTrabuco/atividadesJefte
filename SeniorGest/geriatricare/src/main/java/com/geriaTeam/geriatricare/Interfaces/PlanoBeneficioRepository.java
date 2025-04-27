package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.PlanoBeneficioModels;

import java.util.List;

public interface PlanoBeneficioRepository {
    public PlanoBeneficioModels buscarPorCodigo(int codigo);
    public List<PlanoBeneficioModels> buscar();
    public void adicionar(PlanoBeneficioModels planoBeneficioModels);
    public void remover(int codigo);
    public void atualizar(PlanoBeneficioModels planoBeneficioModels);
}
