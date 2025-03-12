package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Familiar;

import java.util.List;

public interface FamiliarRepository {
    public Familiar buscarPorCodigo(int codigo);
    public List<Familiar> buscar();
    public void adicionar(Familiar familiar);
    public void remover(int codigo);
    public void atualizar(int codigo, Familiar familiar);
    public boolean vazio();
}
