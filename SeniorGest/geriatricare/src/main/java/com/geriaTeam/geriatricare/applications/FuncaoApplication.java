package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.entities.Funcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoApplication {
    private final Funcao funcao;

    private final FuncaoRepository funcaoRepository;

    @Autowired
    public FuncaoApplication(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
        this.funcao = new Funcao(funcaoRepository);
    }

    // Adicionar Funcao
    public void adicionarFuncao(String nome) {
        funcao.adicionarFuncao(nome);
    }

    // Remover Funcao
    public void removerFuncao(int id) {
        funcao.removerFuncao(id);
    }

    // Buscar Funcao por ID
    public FuncaoModels buscarFuncao(int id) {
        return funcao.buscarFuncao(id);
    }

    // Atualizar Funcao
    public void atualizarFuncao(int id, String novoNome) {
        funcao.atualizarFuncao(id, novoNome);
    }

    // Buscar Todas Funções
    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcao.buscarTodasFuncoes();
    }

    // Funções adicionais que interagem diretamente com o repositório
    public void adicionar(FuncaoModels funcaoModels) {
        funcaoRepository.adicionar(funcaoModels);
    }

    public void atualizar(FuncaoModels funcaoModels) {
        funcaoRepository.atualizar(funcaoModels);
    }

    public void remover(int codigo) {
        funcaoRepository.remover(codigo);
    }

    public List<FuncaoModels> buscar() {
        return funcaoRepository.buscar();
    }

    public FuncaoModels buscarPorCodigo(int codigo) {
        return funcaoRepository.buscarPorCodigo(codigo);
    }
}
