package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import com.geriaTeam.geriatricare.entities.Funcao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncaoApplication {
    private final FuncaoRepository funcaoRepository;

    @Autowired
    public FuncaoApplication(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public void adicionarFuncao(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }

        FuncaoModels funcao = new FuncaoModels();
        funcao.setNome(nome);

        funcaoRepository.adicionar(funcao);
    }

    public void removerFuncao(int id) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);
        if (funcao != null) {
            funcaoRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Função não encontrada.");
        }
    }

    public FuncaoModels buscarFuncao(int id) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);
        if (funcao == null) {
            throw new EntityNotFoundException("Função não encontrada.");
        }
        return funcao;
    }

    public void atualizarFuncao(int id, String novoNome) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        if (!validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido: " + novoNome);
        }

        FuncaoModels funcao = funcaoRepository.buscarPorCodigo(id);
        if (funcao != null) {
            funcao.setNome(novoNome);
            funcaoRepository.atualizar(funcao);
        } else {
            throw new EntityNotFoundException("Função não encontrada.");
        }
    }

    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcaoRepository.buscar();
    }

    private boolean validarId(int id) {
        return Funcao.validarId(id);
    }

    private boolean validarNome(String nome) {
        return Funcao.validarNome(nome);
    }
}