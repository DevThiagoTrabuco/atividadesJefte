package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteModels;

import java.util.List;

public interface PacienteRepository {
    PacienteModels buscarPacienteId(int codigo);
    List<PacienteModels> buscarPaciente();
    List<PacienteModels> buscarPacienteNome(String nome);
    void adicionarPaciente(PacienteModels pacienteModels);
    void removerPaciente(int codigo);
    void atualizarPaciente(PacienteModels pacienteModels);
}