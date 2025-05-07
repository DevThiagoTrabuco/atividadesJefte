package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;

import java.util.List;

public interface PacienteFamiliarRepository {
    public PacienteFamiliarModels buscarPacienteFamiliarId(int codigo);
    public List<PacienteFamiliarModels> buscarPacienteFamiliar();
    public void adicionarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels);
    public void removerPacienteFamiliar(int codigo);
    public void atualizarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels);
    public PacienteFamiliarModels buscarPorPacienteIdEFamiliarId(int pacienteId, int familiarId);
}
