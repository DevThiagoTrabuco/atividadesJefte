package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Funcao {
    private int id;
    private String nome;

    // Método para converter a entidade Funcao para FuncaoModels
    public FuncaoModels toModel() {
        FuncaoModels funcaoModels = new FuncaoModels();
        funcaoModels.setNome(this.nome);
        return funcaoModels;
    }

    // 1. Adicionar Funcao
    public void adicionarFuncao(String nome) {
        FuncaoModels funcao = new FuncaoModels();
        funcao.setNome(nome);

        // Adicionando a função no banco de dados
        funcaoRepository.adicionar(funcao);
    }

    // 2. Remover Funcao
    public void removerFuncao(int id) {
        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);  // Busca a função pelo id
        if (funcao != null) {
            funcaoRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Função não encontrada.");
        }
    }

    // 3. Buscar Funcao
    public FuncaoModels buscarFuncao(int id) {
        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);
        if (funcao == null) {
            throw new EntityNotFoundException("Função não encontrada.");
        }
        return funcao;
    }

    // 4. Atualizar Funcao
    public void atualizarFuncao(int id, String novoNome) {
        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);
        if (funcao != null) {
            funcao.setNome(novoNome);
            funcaoRepository.atualizar(funcao);
        } else {
            throw new EntityNotFoundException("Função não encontrada.");
        }
    }

    // 5. Buscar Todas Funções
    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcaoRepository.buscar();
    }
}
