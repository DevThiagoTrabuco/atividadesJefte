package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.Indicador;

public interface IndicadorRepository {
    public Indicador buscarPorCodigo(int codigo);
    public List<Indicador> buscar();
    public void adicionar(Indicador indicador);
    public void remover(int codigo);
    public void atualizar(Indicador indicador);
}
