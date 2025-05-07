package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FamiliarApplication;
import com.geriaTeam.geriatricare.models.FamiliarModels;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FamiliarFacade {
    @Autowired
    private FamiliarApplication familiarApplication;

    // Funções básicas de CRUD
    public void adicionarFamiliar(FamiliarModels familiarModels) {
        familiarApplication.adicionarFamiliar(familiarModels);
    }

    public void removerFamiliar(int id) {
        familiarApplication.removerFamiliar(id);
    }

    public FamiliarModels buscarFamiliarId(int id) {
        return familiarApplication.buscarFamiliarId(id);
    }

    public FamiliarModels buscarFamiliarCpf(String Cpf) {
        return familiarApplication.buscarFamiliarCpf(Cpf);
    }

    public List<FamiliarModels> buscarPorNome(String nome, String sobrenome) {
        return familiarApplication.buscarPorNome(nome, sobrenome);
    }

    public void atualizarFamiliar(FamiliarModels familiarModels) {
        familiarApplication.atualizarFamiliar(familiarModels);
    }

    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarApplication.buscarTodosFamiliares();
    }
}
