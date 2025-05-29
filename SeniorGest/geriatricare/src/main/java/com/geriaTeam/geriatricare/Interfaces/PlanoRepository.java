package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import java.util.Optional;

import com.geriaTeam.geriatricare.models.PlanoModels;

public interface PlanoRepository {
    Optional<PlanoModels> buscarPlanoId(int codigo);
    List<PlanoModels> buscarPlano();
    void adicionarPlano(PlanoModels planoModels);
    void removerPlano(int codigo);
    void atualizarPlano(PlanoModels planoModels);
    List<PlanoModels> buscarPlanoNome(String nome);

}
