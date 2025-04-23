package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;

import java.util.List;

public interface PacienteFamiliarRepository {
    public PacienteFamiliarModels buscarPorCodigo(int codigo);
    public List<PacienteFamiliarModels> buscar();
    public void adicionar(PacienteFamiliarModels pacienteFamiliarModels);
    public void remover(int codigo);
    public void atualizar(PacienteFamiliarModels pacienteFamiliarModels);
    public PacienteFamiliarModels buscarPorPacienteIdEFamiliarId(int pacienteId, int familiarId);
}
