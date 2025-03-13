package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.FuncaoRepository;
import com.geriaTeam.geriatricare.models.domain.Funcao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FuncaoRepositoryImpl implements FuncaoRepository {
    private List<Funcao> funcoes = new ArrayList<>();

    @Override
    public Funcao buscarPorCodigo(int codigo) {
        Funcao funcao = funcoes
        .stream()
        .filter(l -> l.getId() == codigo)
        .findFirst()
        .get();

        return funcao;
    }

    @Override
    public List<Funcao> buscar() {
        return funcoes;
    }

    @Override
    public void adicionar(Funcao funcao) {
        funcoes.add(funcao);
    }

    @Override
    public void remover(int codigo) {
        funcoes.removeIf(l -> l.getId() == codigo);
    }

    @Override
    public void atualizar(int codigo, Funcao funcao) {
        Funcao funcaoInMemory = this.buscarPorCodigo(codigo);
        funcaoInMemory.setName(funcao.getName());
    }
}
