package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FuncaoApplication;
import com.geriaTeam.geriatricare.models.domain.Funcao;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FuncaoFacade {
    @Autowired
    private FuncaoApplication funcaoApplication;

    public List<Funcao> buscar() {
        return funcaoApplication.buscar();
    }

    public Funcao buscarPorCodigo(int codigo) {
        return funcaoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Funcao funcao) {
        funcaoApplication.adicionar(funcao);
    }

    public void atualizar(int codigo, Funcao funcao) {
        funcaoApplication.atualizar(codigo, funcao);
    }

    public void remover(int codigo) {
        funcaoApplication.remover(codigo);
    }
}
