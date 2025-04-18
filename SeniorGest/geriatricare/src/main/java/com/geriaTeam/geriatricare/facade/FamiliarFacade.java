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
    public List<FamiliarModels> buscar() {
        return familiarApplication.buscar();
    }

    public FamiliarModels buscarPorCodigo(int codigo) {
        return familiarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(FamiliarModels familiarModels) {
        familiarApplication.adicionar(familiarModels);
    }

    public void atualizar(FamiliarModels familiarModels) {
        familiarApplication.atualizar(familiarModels);
    }

    public void remover(int codigo) {
        familiarApplication.remover(codigo);
    }

    // Novas funções adicionais que chamam diretamente os métodos de FamiliarApplication
    public void adicionarFamiliar(String nome, String email, String telefone) {
        familiarApplication.adicionarFamiliar(nome, email, telefone);
    }

    public void removerFamiliar(int id) {
        familiarApplication.removerFamiliar(id);
    }

    public FamiliarModels buscarFamiliar(int id) {
        return familiarApplication.buscarFamiliar(id);
    }

    public void atualizarFamiliar(int id, String novoNome, String novoEmail, String novoTelefone) {
        familiarApplication.atualizarFamiliar(id, novoNome, novoEmail, novoTelefone);
    }

    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarApplication.buscarTodosFamiliares();
    }
}
