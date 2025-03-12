package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.Funcionarios;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FuncionariosFacade {
    @Autowired
    private FuncionariosApplication funcionariosApplication;

    public List<Funcionarios> buscar() {
        return funcionariosApplication.buscar();
    }

    public Funcionarios buscarPorCodigo(UUID codigo) {
        return funcionariosApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Funcionarios funcionarios) {
        funcionariosApplication.cadastrar(funcionarios);
    }

    public void atualizar(UUID codigo, Funcionarios funcionarios) {
        funcionariosApplication.atualizar(codigo, funcionarios);
    }

    public void remover(UUID codigo, Funcionarios funcionarios) {
        funcionariosApplication.remover(codigo, funcionarios);
    }
}
