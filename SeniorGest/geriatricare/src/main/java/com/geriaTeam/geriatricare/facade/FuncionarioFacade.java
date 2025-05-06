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
    private FuncionarioApplication funcionarioApplication;

    public List<FuncionarioModels> buscarTodosFuncionario() {
        return funcionarioApplication.buscarTodosFuncionario();
    }

    public FuncionarioModels buscarFuncionarioId(int codigo) {
        return funcionarioApplication.buscarFuncionarioId(codigo);
    }

    public void adicionarFuncionario(FuncionarioModels funcionarioModels, String adminLogin, String adminSenha) {
        funcionarioApplication.adicionarFuncionario(funcionarioModels, adminLogin, adminSenha);
    }

    public void atualizarFuncionario(FuncionarioModels funcionarioModels, String adminLogin, String adminSenha) {
        funcionarioApplication.atualizarFuncionario(funcionarioModels, adminLogin, adminSenha);
    }

    public void removerFuncionario(int codigo, String adminLogin, String adminSenha) {
        funcionarioApplication.removerFuncionario(codigo, adminLogin, adminSenha);
    }
}


