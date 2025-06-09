package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;

public interface CondicaoFisicaRepository {
    CondicaoFisicaModels buscarPorCodigo(int codigo);
    List<CondicaoFisicaModels> buscar();
    void adicionar(CondicaoFisicaModels condicaoFisicaModels);
    void remover(int codigo);
    void atualizar(CondicaoFisicaModels condicaoFisicaModels);
}
