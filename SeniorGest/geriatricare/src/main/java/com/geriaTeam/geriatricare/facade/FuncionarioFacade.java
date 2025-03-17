package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.Funcionario;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FuncionarioFacade {
    @Autowired
    private FuncionarioApplication FuncionarioApplication;

    public List<Funcionario> buscar() {
        return FuncionarioApplication.buscar();
    }

    public Funcionario buscarPorCodigo(int codigo) {
        return FuncionarioApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Funcionario Funcionario) {
        FuncionarioApplication.adicionar(Funcionario);
    }

    public void atualizar(int codigo, Funcionario Funcionario) {
        FuncionarioApplication.atualizar(codigo, Funcionario);
    }

    public void remover(int codigo) {
        FuncionarioApplication.remover(codigo);
    }
}


