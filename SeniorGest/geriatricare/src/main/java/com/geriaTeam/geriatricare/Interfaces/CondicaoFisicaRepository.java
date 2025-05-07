package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;

public interface CondicaoFisicaRepository {
    CondicaoFisicaModels buscarCondicaoFisicaId(int codigo);
    List<CondicaoFisicaModels> buscarCondicaoFisica();
    void adicionarCondicaoFisica(CondicaoFisicaModels condicaoFisicaModels);
    void removerCondicaoFisica(int codigo);
    void atualizarCondicaoFisica(CondicaoFisicaModels condicaoFisicaModels);
}
