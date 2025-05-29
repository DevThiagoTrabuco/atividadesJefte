package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;

import java.util.List;

public interface PacienteFamiliarRepository {
    PacienteFamiliarModels buscarPacienteFamiliarId(int codigo);
    List<PacienteFamiliarModels> buscarPacienteFamiliar();
    void adicionarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels);
    void removerPacienteFamiliar(int codigo);
    void atualizarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels);
    PacienteFamiliarModels buscarPorPacienteIdEFamiliarId(int pacienteId, int familiarId);
}
