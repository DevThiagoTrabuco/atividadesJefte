package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.PacienteHasPlano;

import java.util.List;

public interface PacienteHasPlanoRepository {
    public PacienteHasPlano buscarPorCodigo(int codigo);
    public List<PacienteHasPlano> buscar();
    public void adicionar(PacienteHasPlano pacienteHasPlano);
    public void remover(int codigo);
    public void atualizar(int codigo, PacienteHasPlano pacienteHasPlano);
    public boolean vazio();
}