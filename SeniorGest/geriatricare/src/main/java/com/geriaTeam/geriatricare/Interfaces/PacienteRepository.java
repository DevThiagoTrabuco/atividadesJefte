package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteModels;

import java.util.List;

public interface PacienteRepository {
    public PacienteModels buscarPacienteId(int codigo);
    public List<PacienteModels> buscarPaciente();
    public List<PacienteModels> buscarPacienteNome(String nome);
    public void adicionarPaciente(PacienteModels pacienteModels);
    public void removerPaciente(int codigo);
    public void atualizarPaciente(PacienteModels pacienteModels);
}