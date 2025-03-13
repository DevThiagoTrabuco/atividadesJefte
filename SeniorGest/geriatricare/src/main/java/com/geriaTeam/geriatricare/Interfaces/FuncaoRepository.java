package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Funcao;

import java.util.List;

public interface FuncaoRepository {
    public Funcao buscarPorCodigo(int codigo);
    public List<Funcao> buscar();
    public void adicionar(Funcao funcao);
    public void remover(int codigo);
    public void atualizar(int codigo, Funcao funcao);
}
