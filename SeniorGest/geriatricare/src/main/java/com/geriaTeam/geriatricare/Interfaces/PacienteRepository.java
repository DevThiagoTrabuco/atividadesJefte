package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.PacienteModels;

import java.util.List;

public interface PacienteRepository {
    public PacienteModels buscarPorCodigo(int codigo);
    public List<PacienteModels> buscar();
    public void adicionar(PacienteModels pacienteModels);
    public void remover(int codigo);
    public void atualizar(PacienteModels pacienteModels);
}