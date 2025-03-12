package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Funcionarios;

import java.util.List;

public interface FuncionariosRepository {
    public Funcionarios buscarPorCodigo(int codigo);
    public List<Funcionarios> buscar();
    public void adicionar(Funcionarios funcionarios);
    public void remover(int codigo);
    public void atualizar(int codigo, Funcionarios funcionarios);
    public boolean vazio();
}