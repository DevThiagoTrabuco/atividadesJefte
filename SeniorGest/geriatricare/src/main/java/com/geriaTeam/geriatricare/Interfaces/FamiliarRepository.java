package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.Familiar;

public interface FamiliarRepository {
    public Familiar buscarPorCodigo(int codigo);
    public List<Familiar> buscar();
    public void adicionar(Familiar familiar);
    public void remover(int codigo);
    public void atualizar(int codigo, Familiar familiar);
}
