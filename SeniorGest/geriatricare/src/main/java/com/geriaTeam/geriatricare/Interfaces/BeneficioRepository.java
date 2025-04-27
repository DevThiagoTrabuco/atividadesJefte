package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.BeneficioModels;

import java.util.List;

public interface BeneficioRepository {
    public BeneficioModels buscarPorCodigo(int codigo);
    public List<BeneficioModels> buscar();
    public void adicionar(BeneficioModels beneficioModels);
    public void remover(int codigo);
    public void atualizar(BeneficioModels beneficioModels);
}
