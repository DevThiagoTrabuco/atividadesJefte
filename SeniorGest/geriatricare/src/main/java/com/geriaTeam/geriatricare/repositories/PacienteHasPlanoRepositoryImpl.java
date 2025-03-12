package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.PacienteHasPlanoRepository;
import com.geriaTeam.geriatricare.models.domain.PacienteHasPlano;

import java.util.List;

public class PacienteHasPlanoRepositoryImpl implements PacienteHasPlanoRepository {
    @Override
    public PacienteHasPlano buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<PacienteHasPlano> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(PacienteHasPlano pacienteHasPlano) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, PacienteHasPlano pacienteHasPlano) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
