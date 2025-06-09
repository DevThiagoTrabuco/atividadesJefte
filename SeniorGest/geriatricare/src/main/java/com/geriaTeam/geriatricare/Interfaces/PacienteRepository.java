package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Paciente;

import java.util.List;

public interface PacienteRepository {
    public Paciente buscarPorCodigo(int codigo);
    public List<Paciente> buscar();
    public void adicionar(Paciente paciente);
    public void remover(int codigo);
    public void atualizar(Paciente paciente);
}