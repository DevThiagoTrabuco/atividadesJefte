package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

import java.util.List;

public interface SinaisVitaisRepository {
    public SinaisVitais buscarPorCodigo(int codigo);
    public List<SinaisVitais> buscar();
    public void adicionar(SinaisVitais sinaisVitais);
    public void remover(int codigo);
    public void atualizar(int codigo, SinaisVitais sinaisVitais);
    public boolean vazio();
}
