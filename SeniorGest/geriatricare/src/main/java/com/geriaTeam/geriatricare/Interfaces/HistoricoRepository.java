package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.domain.Historico;

public interface HistoricoRepository {
    public Historico buscarPorCodigo(int codigo);
    public List<Historico> buscar();
    public void adicionar(Historico historico);
    public void remover(int codigo);
    public void atualizar(int codigo, Historico historico);
}
