package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.PlanoHasPaciente;

import java.util.List;

public interface PlanoHasPacienteRepository {
    public PlanoHasPaciente buscarPorCodigo(int codigo);
    public List<PlanoHasPaciente> buscar();
    public void adicionar(PlanoHasPaciente planoHasPaciente);
    public void remover(int codigo);
    public void atualizar(int codigo, PlanoHasPaciente planoHasPaciente);
    public boolean vazio();
}