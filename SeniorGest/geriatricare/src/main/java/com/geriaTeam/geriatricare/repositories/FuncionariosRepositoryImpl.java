package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.FuncionariosRepository;
import com.geriaTeam.geriatricare.models.domain.Funcionarios;

import java.util.List;

public class FuncionariosRepositoryImpl implements FuncionariosRepository {
    @Override
    public Funcionarios buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Funcionarios> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Funcionarios funcionarios) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Funcionarios funcionarios) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
