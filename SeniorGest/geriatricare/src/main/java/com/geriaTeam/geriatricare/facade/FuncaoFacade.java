package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FuncaoApplication;
import com.geriaTeam.geriatricare.models.FuncaoModels;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FuncaoFacade {
    @Autowired
    private FuncaoApplication funcaoApplication;

    // Funções básicas de CRUD
    public List<FuncaoModels> buscar() {
        return funcaoApplication.buscar();
    }

    public FuncaoModels buscarPorCodigo(int codigo) {
        return funcaoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(FuncaoModels funcaoModels) {
        funcaoApplication.adicionar(funcaoModels);
    }

    public void atualizar(FuncaoModels funcaoModels) {
        funcaoApplication.atualizar(funcaoModels);
    }

    public void remover(int codigo) {
        funcaoApplication.remover(codigo);
    }

    // Novas funções adicionais que chamam diretamente os métodos de FuncaoApplication
    public void adicionarFuncao(String nome) {
        funcaoApplication.adicionarFuncao(nome);
    }

    public void removerFuncao(int id) {
        funcaoApplication.removerFuncao(id);
    }

    public FuncaoModels buscarFuncao(int id) {
        return funcaoApplication.buscarFuncao(id);
    }

    public void atualizarFuncao(int id, String novoNome) {
        funcaoApplication.atualizarFuncao(id, novoNome);
    }

    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcaoApplication.buscarTodasFuncoes();
    }
}
