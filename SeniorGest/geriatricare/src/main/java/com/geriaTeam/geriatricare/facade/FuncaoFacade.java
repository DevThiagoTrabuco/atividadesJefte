package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Funcao buscarPorCodigo(UUID codigo) {
        return funcaoApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Funcao funcao) {
        funcaoApplication.cadastrar(funcao);
    }

    public void atualizar(UUID codigo, Funcao funcao) {
        funcaoApplication.atualizar(codigo, funcao);
    }

    public void remover(UUID codigo, Funcao funcao) {
        funcaoApplication.remover(codigo, funcao);
    }
}
