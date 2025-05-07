package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;

import com.geriaTeam.geriatricare.models.FamiliarModels;

public interface FamiliarRepository {
    FamiliarModels buscarFamiliarId(int codigo);
    FamiliarModels buscarFamiliarCpf(String cpf);
    List<FamiliarModels> buscarFamiliarNome(String nomeCompleto);
    List<FamiliarModels> buscarFamiliar();
    void adicionarFamiliar(FamiliarModels familiarModels);
    void removerFamiliar(int codigo);
    void atualizarFamiliar(FamiliarModels familiarModels);
}
