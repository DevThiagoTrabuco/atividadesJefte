package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FuncionarioApplication;
import com.geriaTeam.geriatricare.models.FuncionarioModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FuncionarioFacade {
    @Autowired
    private FuncionarioApplication FuncionarioApplication;

    public List<FuncionarioModels> buscar() {
        return FuncionarioApplication.buscar();
    }

    public FuncionarioModels buscarPorCodigo(int codigo) {
        return FuncionarioApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(FuncionarioModels FuncionarioModels) {
        FuncionarioApplication.adicionar(FuncionarioModels);
    }

    public void atualizar(FuncionarioModels FuncionarioModels) {
        FuncionarioApplication.atualizar(FuncionarioModels);
    }

    public void remover(int codigo) {
        FuncionarioApplication.remover(codigo);
    }
}


