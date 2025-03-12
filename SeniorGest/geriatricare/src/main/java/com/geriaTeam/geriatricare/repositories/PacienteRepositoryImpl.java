package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.domain.Paciente;

import java.util.List;

public class PacienteRepositoryImpl implements PacienteRepository {
    @Override
    public Paciente buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Paciente> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Paciente paciente) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Paciente paciente) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
