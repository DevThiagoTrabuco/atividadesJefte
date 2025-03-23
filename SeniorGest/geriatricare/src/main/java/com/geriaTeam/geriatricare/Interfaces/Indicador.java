package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

public interface SinaisVitaisRepository {
    public SinaisVitais buscarPorCodigo(int codigo);
    public List<SinaisVitais> buscar();
    public void adicionar(SinaisVitais sinaisvitais);
    public void remover(int codigo);
    public void atualizar(int codigo, SinaisVitais sinaisvitais);
}
