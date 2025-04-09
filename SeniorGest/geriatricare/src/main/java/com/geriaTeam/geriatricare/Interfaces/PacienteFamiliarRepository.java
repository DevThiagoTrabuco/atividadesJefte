package com.geriaTeam.geriatricare.Interfaces;


import com.geriaTeam.geriatricare.models.domain.PacienteFamiliar;

import java.util.List;

public interface PacienteFamiliarRepository {
    public PacienteFamiliar buscarPorCodigo(int codigo);
    public List<PacienteFamiliar> buscar();
    public void adicionar(PacienteFamiliar pacienteFamiliar);
    public void remover(int codigo);
    public void atualizar(PacienteFamiliar pacienteFamiliar);
}
